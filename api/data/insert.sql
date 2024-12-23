INSERT INTO public.passageiro(
	nome, cpf, saldo_em_conta, numero_de_corridas, quantidade_de_avaliacoes, soma_das_notas, media_das_avaliacoes, data_nascimento)
	VALUES ('Maria de Lourdes', '38269166898', '50', 0, 0, 0, 5, '1990-05-23');
INSERT INTO public.passageiro(
	nome, cpf, saldo_em_conta, numero_de_corridas, quantidade_de_avaliacoes, soma_das_notas, media_das_avaliacoes, data_nascimento)
	VALUES ('Jose Afonso Santos', '78581080421', '40', 0, 0, 0, 5, '1990-08-23');
INSERT INTO public.passageiro(
    nome, cpf, saldo_em_conta, numero_de_corridas, quantidade_de_avaliacoes, soma_das_notas, media_das_avaliacoes, data_nascimento)
VALUES ('Roger Weber', '85721747706', '1500', 0, 0, 0, 5, '1990-08-23');
INSERT INTO public.passageiro(
    nome, cpf, saldo_em_conta, numero_de_corridas, quantidade_de_avaliacoes, soma_das_notas, media_das_avaliacoes, data_nascimento)
VALUES ('Fernando Soares', '14748366311', '999', 0, 0, 0, 5, '1990-08-23');



INSERT INTO public.motorista(
	nome, data_nascimento, cpf, saldo_em_conta, habilitacao_numero, habilitacao_categoria, habilitacao_data_vencimento, numero_de_corridas, quantidade_de_avaliacoes, soma_das_notas, media_das_avaliacoes)
	VALUES ('Joel Cabral', '1990-04-28', '22816173437', '40', '22816173437', 'B', '2028-05-01', 0, 0, 0, 5);
INSERT INTO public.motorista(
	nome, data_nascimento, cpf, saldo_em_conta, habilitacao_numero, habilitacao_categoria, habilitacao_data_vencimento, numero_de_corridas, quantidade_de_avaliacoes, soma_das_notas, media_das_avaliacoes)
	VALUES ('Afonso Barreto', '1990-04-28', '68268552670', '40', '68268552670', 'B', '2030-05-01', 0, 0, 0, 5);
INSERT INTO public.motorista(
	nome, data_nascimento, cpf, saldo_em_conta, habilitacao_numero, habilitacao_categoria, habilitacao_data_vencimento, numero_de_corridas, quantidade_de_avaliacoes, soma_das_notas, media_das_avaliacoes)
	VALUES ('Carlos Lima', '1990-04-28', '45887607939', '40', '45887607939', 'B', '2020-05-01', 0, 0, 0, 5);
INSERT INTO public.motorista(
    nome, data_nascimento, cpf, saldo_em_conta, habilitacao_numero, habilitacao_categoria, habilitacao_data_vencimento, numero_de_corridas, quantidade_de_avaliacoes, soma_das_notas, media_das_avaliacoes)
VALUES ('Mariana Viana', '1990-04-28', '14434322532', '2000', '14434322532', 'B', '2020-05-01', 0, 0, 0, 5);



INSERT INTO public.veiculo(
	placa, modelo, cor, foto_url, proprietario_id, categoria)
	VALUES ('BRA3L78', 'Eclipse', 'Vermelho', 'https://www.chevrolet.com.br/content/dam/chevrolet/mercosur/brazil/portuguese/index/cars/cars-subcontent/02-images/cruze-sport6-rs-carros.jpg?imwidth=960', '1', 'B');
INSERT INTO public.veiculo(
	placa, modelo, cor, foto_url, proprietario_id, categoria)
	VALUES ('BRA9P52', 'Ferrari LaFerrari', 'Vermelha', 'https://revistacarro.com.br/wp-content/uploads/2018/03/ferrari-laferrari-2014-1280_capa1.jpg', '2', 'B');
INSERT INTO public.veiculo(
	placa, modelo, cor, foto_url, proprietario_id, categoria)
	VALUES ('BRA3T44', 'Lamborghini Veneno', 'Cinza', 'https://fotos.jornaldocarro.estadao.com.br/uploads/2017/08/26120131/lamborghini-veneno-2-1160x775.jpg', '3', 'B');