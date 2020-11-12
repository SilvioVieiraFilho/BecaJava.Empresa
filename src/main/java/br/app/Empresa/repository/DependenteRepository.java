package br.app.Empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.app.Empresa.model.Dependente;




@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long> {

}

