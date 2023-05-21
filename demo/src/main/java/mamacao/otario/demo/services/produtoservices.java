package mamacao.otario.demo.services;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mamacao.otario.demo.model.Produto;
import mamacao.otario.demo.repository.produtoRepository;

@Service
public class produtoservices {
    
    @Autowired
    private produtoRepository produtoRepository;

        /**
         * Método para retornar uma lista de produtos
         * @return Lista de produtos.
         */
        public List<Produto> obrterTodos(){
        //colocar regra caso tenha
        return produtoRepository.obterTodos();
        }

        public Optional<Produto> obterPorId(Integer id){

            return produtoRepository.obterPorId(id);
        }

        public Produto adicionar(Produto produto){

            return produtoRepository.adicionar(produto);
        }

        public void deletar(Integer id){

            produtoRepository.deletar(id);

        }
        public Produto atualizar(Integer id, Produto produto){

            produto.setId(id);

            return produtoRepository.atualizar(produto);
        }
    
    } 

