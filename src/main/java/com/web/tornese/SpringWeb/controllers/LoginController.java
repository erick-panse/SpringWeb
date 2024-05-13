package com.web.tornese.SpringWeb.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.web.tornese.SpringWeb.models.Administrador;
import com.web.tornese.SpringWeb.repositorio.AdministradoresRepo;
import com.web.tornese.SpringWeb.servico.CookieService;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class LoginController {
    @Autowired
    private AdministradoresRepo repo;

    @GetMapping("/login")
    public String index(){
        return "login/index";
    }

    @PostMapping("/logar")
    public String logar(Model model, Administrador admParam, String lembrar, HttpServletResponse response) throws IOException{
        Administrador adm = this.repo.Login(admParam.getEmail(), admParam.getSenha());
        if (adm != null) {
            int tempoLogado = (60*60); // 1 hora de cookie
            if(lembrar != null) tempoLogado= (60*60*24*365); // 1 ano de cookie
            CookieService.setCookie(response, "usuariosId", String.valueOf(adm.getId()), tempoLogado);
            CookieService.setCookie(response, "nomeUsuario", String.valueOf(adm.getNome()), tempoLogado);
            return "redirect:/";
        }
        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "login/index";
    }

    @GetMapping("/sair")
    public String logar(HttpServletResponse response) throws IOException{
        CookieService.setCookie(response, "usuariosId", "", 0);
        CookieService.setCookie(response, "nomeUsuario", "", 0);
        return "redirect:/login";
    
    }

}
