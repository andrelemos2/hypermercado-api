CREATE TABLE produto (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	valor NUMERIC(10,2) NOT NULL,
	src VARCHAR(1000) NOT NULL,
	observacoes VARCHAR(250),
	ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO produto (nome, valor, src, observacoes, ativo) values ('Xbox', 1320.00, 'https://www.google.com.br/imgres?imgurl=https%3A%2F%2Fassets.console-deals.com%2Fimages%2Fcontent%2Fxboxone%2Fxbox-one.png&imgrefurl=https%3A%2F%2Fwww.console-deals.com%2Fxboxone%2F&docid=rB69GUud3TeGrM&tbnid=c9Q9wQdVv733_M%3A&vet=10ahUKEwiAkrbGg_7VAhWLD5AKHaXWBJQQMwgmKAAwAA..i&w=550&h=305&bih=590&biw=1280&q=xbox%20one&ved=0ahUKEwiAkrbGg_7VAhWLD5AKHaXWBJQQMwgmKAAwAA&iact=mrc&uact=8', 'Tecnologia', true);
INSERT INTO produto (nome, valor, src, observacoes, ativo) values ('Playstation', 1500.00, 'https://www.google.com.br/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjuqtL5gv7VAhWMk5AKHXu6BzUQjRwIBw&url=https%3A%2F%2Fwww.playstation.com%2Fpt-br%2Fexplore%2Fps4%2F&psig=AFQjCNGhyQXx4cvvish7j0DPgO8FJj3wGQ&ust=1504150374070834', 'Tecnologia', true);
INSERT INTO produto (nome, valor, src, observacoes, ativo) values ('SmartTv', 2500.00, 'https://www.google.com.br/imgres?imgurl=http%3A%2F%2Fshopfacil.vteximg.com.br%2Farquivos%2Fsmartv.png&imgrefurl=http%3A%2F%2Fwww.shopfacil.com.br%2Feletronicos%2Ftvs%2Fsmart-tv&docid=x3mJ4jZASzMy6M&tbnid=oiaDI7E26LN5gM%3A&vet=10ahUKEwityp_Wg_7VAhXCIpAKHdJyA9wQMwgmKAAwAA..i&w=430&h=300&bih=590&biw=1280&q=smart%20tv&ved=0ahUKEwityp_Wg_7VAhXCIpAKHdJyA9wQMwgmKAAwAA&iact=mrc&uact=8', 'Tecnologia', true);
INSERT INTO produto (nome, valor, src, observacoes, ativo) values ('Teclado USB', 132.00, 'https://www.google.com.br/imgres?imgurl=http%3A%2F%2Fs2.glbimg.com%2FnAy0zWAWo1au_9v_L4wlIEDRB24%3D%2F0x0%3A1200x448%2F695x259%2Fs.glbimg.com%2Fpo%2Ftt2%2Ff%2Foriginal%2F2015%2F11%2F06%2Ff1.png&imgrefurl=http%3A%2F%2Fwww.techtudo.com.br%2Flistas%2Fnoticia%2F2015%2F11%2Fconfira-funcoes-de-teclas-desconhecidas-do-teclado-do-windows.html&docid=J1aw36gbPvwAbM&tbnid=ilJlm-H-2-TU0M%3A&vet=10ahUKEwjVy9vdg_7VAhUDl5AKHXOOA9IQMwgmKAAwAA..i&w=695&h=259&bih=590&biw=1280&q=teclado&ved=0ahUKEwjVy9vdg_7VAhUDl5AKHXOOA9IQMwgmKAAwAA&iact=mrc&uact=8', 'Tecnologia', true);
INSERT INTO produto (nome, valor, src, observacoes, ativo) values ('Mouse sem Fio', 50.00, 'https://www.google.com.br/imgres?imgurl=https%3A%2F%2Fimages-americanas.b2w.io%2Fprodutos%2F01%2F00%2Fitem%2F112747%2F8%2F112747862SZ.jpg&imgrefurl=http%3A%2F%2Fwww.americanas.com.br%2Fproduto%2F112747862&docid=Lpwh-dW_3jYF7M&tbnid=GSIM_BdnUnNRyM%3A&vet=10ahUKEwiW7dfmg_7VAhVEx5AKHQDUAZwQMwhDKAAwAA..i&w=1000&h=1000&bih=590&biw=1280&q=mouse%20sem%20fio&ved=0ahUKEwiW7dfmg_7VAhVEx5AKHQDUAZwQMwhDKAAwAA&iact=mrc&uact=8', 'Tecnologia', true);
