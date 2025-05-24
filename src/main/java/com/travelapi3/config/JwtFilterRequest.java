package com.travelapi3.config;

import com.travelapi3.entity.Travelsignup3;
import com.travelapi3.repository.Travelsignup3Repository;
import com.travelapi3.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Component
public class JwtFilterRequest extends OncePerRequestFilter {

    private JWTService jservice;

    private Travelsignup3Repository trepo;

    public JwtFilterRequest(JWTService jservice, Travelsignup3Repository trepo) {
        this.jservice = jservice;
        this.trepo = trepo;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String tokk = request.getHeader("Authorization");
        System.out.println(tokk);
        if(tokk!=null && tokk.startsWith("Bearer")) {
            String substring = tokk.substring(7);

            String uname = jservice.getusername(substring);

            Optional<Travelsignup3> opt = trepo.findByUsername(uname);

            if(opt.isPresent()){

                Travelsignup3 tentity = opt.get();
                UsernamePasswordAuthenticationToken uu=new UsernamePasswordAuthenticationToken(
                    tentity,null, Collections.singleton(new SimpleGrantedAuthority(tentity.getRole())));

                uu.setDetails(new WebAuthenticationDetails(request));
                SecurityContextHolder.getContext().setAuthentication(uu);

            }
        }

        filterChain.doFilter(request,response);
    }
}
