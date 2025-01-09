package com.web.tornese.SpringWeb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.web.tornese.SpringWeb.models.Administrador;
import com.web.tornese.SpringWeb.repositorio.AdministradoresRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringWebApplication.class)
class SpringWebApplicationTests {
  @Autowired
  private AdministradoresRepo repo;

  @Test
  void salvaAdmNoBancoDeDados() {
    limpaCriaUsuario();
    assertEquals(1, repo.count());
  }

  @Test
  void atualizaRegistro() {
    Administrador adm = limpaCriaUsuario();

    String novaSenha = "123456";
    adm.setSenha(novaSenha);
    repo.save(adm);

    assertEquals(novaSenha, repo.findById(adm.getId()).get().getSenha());
  }

  @Test
  void buscaLoginSenha() {
    Administrador adm = limpaCriaUsuario();
    assertEquals(true, repo.Login(adm.getEmail(), adm.getSenha()) != null);
  }

  @Test
  void existePorId() {
    Administrador adm = limpaCriaUsuario();
    assertEquals(true, repo.exist(adm.getId()));
  }

  @Test
  void apagarUsuario() {
    Administrador adm = limpaCriaUsuario();
    repo.delete(adm);
    assertEquals(0, repo.count());
  }

  private Administrador limpaCriaUsuario() {
    repo.deleteAll();

    Administrador adm = new Administrador();
    adm.setNome("Erick");
    adm.setEmail("Erick@SpringWeb.com.br");
    adm.setSenha("ddd19291ms");
    adm.setObservacao("um teste");
    repo.save(adm);

    return adm;
  }
}
