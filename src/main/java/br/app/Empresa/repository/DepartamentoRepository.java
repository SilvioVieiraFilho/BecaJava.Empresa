package br.app.Empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.app.Empresa.model.Departamento;


@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

}

