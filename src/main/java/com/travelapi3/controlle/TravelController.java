package com.travelapi3.controlle;

import com.travelapi3.entity.Travelsignup3;
import com.travelapi3.payload.JwtDto;
import com.travelapi3.payload.loginDtp;
import com.travelapi3.repository.Travelsignup3Repository;
import com.travelapi3.service.JWTService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/travel3")
public class TravelController {

    private Travelsignup3Repository trepo;
    private JWTService jservice;

    public TravelController(Travelsignup3Repository trepo, JWTService jservice) {
        this.trepo = trepo;
        this.jservice = jservice;
    }

    @PostMapping("/add")
    public ResponseEntity<Travelsignup3> add(

            @RequestBody Travelsignup3 tt
            ){

        tt.setPassword(BCrypt.hashpw(tt.getPassword(),BCrypt.gensalt(10)));
        Travelsignup3 saved = trepo.save(tt);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verify(
            @RequestBody loginDtp dto
    ){

        Optional<Travelsignup3> opt=trepo.findByUsername(dto.getUsername());

        if(opt.isPresent()){
            Travelsignup3 ttentity = opt.get();

            if(BCrypt.checkpw(dto.getPassword(), ttentity.getPassword())){

                String token = jservice.generatetoken(dto);
                JwtDto dto123 =new JwtDto();
                dto123.setType("jwt token");
                dto123.setToken(token);

                return new ResponseEntity<>(dto123,HttpStatus.OK);
            }
        }



        return new ResponseEntity<>("nikal lode",HttpStatus.BAD_REQUEST);
    }


}
