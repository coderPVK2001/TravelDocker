package com.travelapi3.controlle;

import com.travelapi3.entity.VehicleDetails;
import com.travelapi3.repository.VehicleDetailsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practiseapi/pp")
public class VehicleController {

    private VehicleDetailsRepository vrepo;

    public VehicleController(VehicleDetailsRepository vrepo) {
        this.vrepo = vrepo;
    }

    @PostMapping("/add1")
    public ResponseEntity<?> ddd(
            @RequestBody VehicleDetails vd
            ){

        VehicleDetails saved = vrepo.save(vd);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

//    @GetMapping("/getdetails")
//    public ResponseEntity<?> ddd(
//            @RequestParam(name="pageNo"   , defaultValue = "0" ,required = false) int pageno,
//            @RequestParam(name="pagesize" , defaultValue = "4" ,required = false) int size
//    ){
//
//        PageRequest pr = PageRequest.of(pageno, size);
//        Page<VehicleDetails> allpr = vrepo.findAll(pr);
//        List<VehicleDetails> list = allpr.toList();
//
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }



}
