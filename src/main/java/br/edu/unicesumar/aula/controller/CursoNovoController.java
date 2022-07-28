package br.edu.unicesumar.aula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unicesumar.aula.domain.CursoNovo;
import br.edu.unicesumar.aula.service.CursoNovoService;

@RestController
@RequestMapping("/cursoNovo")
public class CursoNovoController {
    @Autowired
	private CursoNovoService service;
	
	@GetMapping("/{id}")
	public CursoNovo buscarCursoPorId(@PathVariable(name="id") Long id){
		return service.findById(id);
	}
	
	@GetMapping
	public Page<CursoNovo> buscarTodasOsCursos(Pageable pageable){
		return service.findAll(pageable);
	}
	
	@PostMapping
	public CursoNovo criarNovoCurso(@RequestBody CursoNovo cursoNovo) {
		return this.service.save(cursoNovo);
	}
	
	@PutMapping("/{id}")
	public CursoNovo alterarDadosDoCurso(@PathVariable(name="id") Long id, @RequestBody CursoNovo cursoNovo) {
		return this.service.update(cursoNovo, id);
	}
	
	@DeleteMapping("/{id}")
	public void deletarUmCursoExistente(@PathVariable(name="id") Long id) {
		this.service.deleteById(id);
	}
}
