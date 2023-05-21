package mamacao.otario.demo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.stereotype.Repository;

import ch.qos.logback.core.filter.Filter;
import mamacao.otario.demo.model.Produto;

@Repository
public class produtoRepository {
    
    private List<Produto> produtos = new List<produto>();
    private Integer ultimoID = 0;


    /**
     * Método para retornar uma lista de produtos    
     * @return lista de produtos
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Método que retorna o produto encontrado pelo seu id
     * @param id do produto que será localizado
     * @return Retorna um produto caso tenha encontrado
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos
            .stream()
            .filter(produto -> produto.getId() == id )
            .findFirst();
    }

    /**
     * Método para adicionar produto na lista
     * @param produto que será adicionado
     * @return produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto){
        
        ultimoID++;
        produto.setId(ultimoID);
        produtos.add(produto);

        return produto;
    }

    /**
     * Método para deletar o produto por id.
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){

        produtos.removeIf(produto -> produto.getId() == id);

    }

    /**
     * Método para atualizar o produto da lista
     * @param produto que será atualizado
     * @return retorna o produto após atualizar a lista.
     */
    public Produto atualizar(Produto produto){
        // remover o produto antigo da lista
        //adicionar o novo produto
        
        Optional<Produto> produtoencontrado == obterPorId(Produto.getId());

        if(produtoencontrado.isEmpty()){
            throw new InputMismatchException("Produto não encontrado");


        deletar(produto.getId());

        produtos.add(produto);


        return produto;
        
        }
    }

    private Optional<Produto> obterPorId(Integer id) {
        return null;
    }

}
