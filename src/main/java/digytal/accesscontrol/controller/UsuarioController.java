package digytal.accesscontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import digytal.accesscontrol.model.Usuario;
import digytal.accesscontrol.repository.UsuarioRepository;

import java.util.List;
@RestController

@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    
    @GetMapping
    public List<Usuario> list(){
        return repository.findAll();
    }
    @PostMapping
    public void save(@RequestBody Usuario usuario){
        repository.save(usuario);
    }
    @PutMapping
    public void update(@RequestBody Usuario usuario){
        repository.save(usuario);
    }
    @GetMapping("/{username}")
    public Usuario find(@PathVariable("username") String username){
        return repository.findByUsername(username);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("/id") Integer id){
        repository.deleteById(id);
    }
}

