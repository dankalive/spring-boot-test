package mamacao.otario.demo.controler;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mamacao.otario.demo.services.produtoservices;

@RestController
@RequestMapping("/api/produtos")

public class ProdutoController<Produto> {

    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping
    public List<produto> obterTodos(){

        return produtoService.obrterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterPorId(@PathVariable Integer Id){
        return produtoService.obterPorId(Id);
    }

    @PostMapping
    public Produto adicionar(@RequestBody, Produto produto){
        return produtoService.adicionar(produto);


    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        produtoService.deletar(id);
            return "Produto com id:" + id + "foi deletado com sucesso";
    }

    @PutMapping
    public ProdutoController(@RequestBody Produto produto, @PathVariable Integer id){
        return produtoService.atualizar(id, produto);

    }



    }
