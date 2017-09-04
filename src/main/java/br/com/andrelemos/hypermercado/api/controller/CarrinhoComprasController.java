package br.com.andrelemos.hypermercado.api.controller;

import br.com.andrelemos.hypermercado.api.model.CarrinhoCompras;
import br.com.andrelemos.hypermercado.api.model.CarrinhoItem;
import br.com.andrelemos.hypermercado.api.model.Produto;
import br.com.andrelemos.hypermercado.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/carrinho")
@Scope(value= WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private CarrinhoCompras carrinho;

    @RequestMapping("/add")
    public ModelAndView add(Long codigo) {
        ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
        CarrinhoItem carrinhoItem = criaItem(codigo);
        carrinho.add(carrinhoItem);
        return modelAndView;
    }

    private CarrinhoItem criaItem(Long codigo) {
        Produto produto = service.buscaPorCodigo(codigo);
        CarrinhoItem carrinhoItem = new CarrinhoItem(produto);
        return carrinhoItem;
    }

}
