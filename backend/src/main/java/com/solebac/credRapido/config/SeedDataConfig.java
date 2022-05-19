package com.solebac.credRapido.config;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.solebac.credRapido.Utils.AutenticationEncoder;
import com.solebac.credRapido.entities.Atendentes;
import com.solebac.credRapido.entities.Banco;
import com.solebac.credRapido.entities.Beneficios;
import com.solebac.credRapido.entities.Clientes;
import com.solebac.credRapido.entities.Conta;
import com.solebac.credRapido.entities.Perfil;
import com.solebac.credRapido.entities.Servicos;
import com.solebac.credRapido.entities.Users;
import com.solebac.credRapido.entities.dependency.Endereco;
import com.solebac.credRapido.entities.dependency.Telefone;
import com.solebac.credRapido.entities.enums.EstadoCivil;
import com.solebac.credRapido.entities.enums.MeioPgto;
import com.solebac.credRapido.entities.enums.Sexo;
import com.solebac.credRapido.entities.enums.TipoFone;
import com.solebac.credRapido.entities.enums.TipoLogradouro;
import com.solebac.credRapido.entities.enums.Uf;
import com.solebac.credRapido.repositories.AtendentesRepository;
import com.solebac.credRapido.repositories.BancosRepository;
import com.solebac.credRapido.repositories.BeneficiosRepository;
import com.solebac.credRapido.repositories.ClientesRepository;
import com.solebac.credRapido.repositories.ContasRepository;
import com.solebac.credRapido.repositories.PerfilRepository;
import com.solebac.credRapido.repositories.ServicosRepository;
import com.solebac.credRapido.repositories.security.UsersRepository;

@Configuration
@Profile("test")
public class SeedDataConfig implements CommandLineRunner {

	@Autowired
	private BeneficiosRepository benef;
	
	@Autowired
	private ServicosRepository servicos;

	@Autowired
	private ClientesRepository clients;

	@Autowired
	private AtendentesRepository atendentes;

	@Autowired
	private BancosRepository bancos;

	@Autowired
	private ContasRepository contas;
	
	@Autowired
	private UsersRepository users;
	
	@Autowired
	private PerfilRepository perfil;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public void run(String... args) throws Exception {
		
		Perfil per1 = new Perfil("USER");
		Perfil per2 = new Perfil("ADMIN");
		perfil.saveAll(Arrays.asList(per1,per2));
		
		Users u1 = new Users(null, "teste", "teste@teste", "12345");
		users.save(u1);
		Users u2 = new Users(null, "Fulano", "fulano@teste", "123");
		users.save(u2);
		
		Atendentes at1 = new Atendentes(null, "Fulano", "34978210011", "https://www.placecage.com/280/240");
		Atendentes at2 = new Atendentes(null, "Leandro", "34978210045", "https://loremflickr.com/320/240");
		Atendentes at3 = new Atendentes(null, "Gabriel", "34978615545", "https://picsum.photos/200/300?random=2");
		atendentes.saveAll(Arrays.asList(at1, at2, at3));

		servicos.saveAll(Arrays.asList(new Servicos(null, "Empréstimo consignado",
				"O Crédito consignado é um empréstimo com pagamento indireto, cujas parcelas são deduzidas diretamente da folha de pagamento ou benefício da pessoa física."),
				new Servicos(null, "Empréstimo Pessoal",
						"Você pode alivar suas despesas, pagamento de contas ou organizar sua vida financeira. Também pode solucionar um imprevisto e até realizar sonhos."),
				new Servicos(null, "Empréstimo com débito em conta",
						"Mais uma modalidade de crédito pessoal. Seu diferencial é o fato do valor da parcela da dívida ser descontado automaticamente da conta bancária do consumidor. O que pode ser uma vantagem e também uma desvantagem dessa linha."),
				new Servicos(null, "Refinanciamento",
						"Nossos profissionais lhe oferecem nada mais é do que trocar um contrato de empréstimo antigo por um novo na mesma instituição financeira, sendo possível fazer alterações no prazo e valores contratados."),
				new Servicos(null, "Portabilidade",
						"Você pode solicitar a transferência de seus empréstimos contratados em outros bancos para o seu banco de movimento e ter as parcelas debitadas direto em sua folha de pagamento ou em conta.")));

		Endereco address = new Endereco("Araxá", "Rua A", "Novo São Geraldo", "381800000", "123", Uf.MG,
				TipoLogradouro.AVENIDA);
		Endereco address1 = new Endereco("Araxá", "Rua B", "São Geraldo", "381800139", "1123", Uf.MG,
				TipoLogradouro.RUA);
		Endereco addres2 = new Endereco("Araxá", "Rua C", "ALVORADA", "381800080", "1232", Uf.MG, TipoLogradouro.RUA);
		Endereco address3 = new Endereco("Araxá", "Rua D", "Santo Antonio", "381800101", "1523", Uf.MG,
				TipoLogradouro.CONJUNTO);

		Telefone fone = new Telefone(TipoFone.TELEFONE, "34987217745");
		Telefone fone1 = new Telefone(TipoFone.CELULAR, "34987214577");
		Telefone fone2 = new Telefone(TipoFone.CELULAR, "34987216787");
		Telefone fone3 = new Telefone(TipoFone.TELEFONE, "34987213454");

		Clientes c1 = new Clientes(null, "Maria das Rosas", "1234567890012", "Isento", "solebac@teste", Sexo.MASCULINO,
				EstadoCivil.SOLTEIRO, new Date(), true, 1400.00, sdf.parse("24/12/1978"), address, fone, at2);
		Clientes c2 = new Clientes(null, "Flavio Rogerio da Silva", "8912345678900", "Isento", "solebac@teste",
				Sexo.MASCULINO, EstadoCivil.CASADO, new Date(), false, 1300.00, new Date(), address1, fone1, at1);
		Clientes c3 = new Clientes(null, "Ana Mariada Silva", "8912345676870", "Isento", "ana@teste", Sexo.FEMININO,
				EstadoCivil.CASADO, new Date(), false, 1200.00, new Date(), address1, fone1, at1);
		Clientes c4 = new Clientes(null, "Felipo Rogerio da Silva", "8912345558900", "Isento", "felipo@teste",
				Sexo.MASCULINO, EstadoCivil.CASADO, new Date(), false, 1100.00, sdf.parse("01/01/2000"), address3, fone3, at2);
		clients.saveAll(Arrays.asList(c1, c2, c3, c4, c1, c2, c3, c4));

		Banco b1 = new Banco(341, "ITAU");
		Banco b2 = new Banco(1, "BANCO DE BRASIL");
		bancos.saveAll(Arrays.asList(b1, b2));

		Conta con1 = new Conta(null, "1601", "333333", MeioPgto.CARTAOMAGNETICO, b1);
		Conta con2 = new Conta(null, "1601", "555333", MeioPgto.CONTACORRENTE, b1);
		Conta con3 = new Conta(null, "1601", "658544", MeioPgto.CONTACORRENTE, b2);
		Conta con4 = new Conta(null, "1601", "999888", MeioPgto.CARTAOMAGNETICO, b2);

		contas.saveAll(Arrays.asList(con1, con2, con3, con4));
		SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
		//(Long id, BigInteger contrato, String numberBen, Integer ifo, Date dateBeginBen, Integer especie)
		Beneficios benef1 = new Beneficios(null, new BigInteger("19946654120180529"), "1696625146", 341, spf.parse("14/07/2015"), 21);
		benef1.setCliente(c2);
		benef1.setConta(con2);
		//benef.save(benef1);
		Beneficios benef2 = new Beneficios(null, new BigInteger("19837889520190220"), "5492504254", 341, spf.parse("25/06/2010"), 22, con1, c1);
		//benef.saveAll(Arrays.asList(benef1, benef2));
		Beneficios benef3 = new Beneficios(null, new BigInteger("123352613190"), "545473241", 1, spf.parse("25/06/2010"), 21, con3, c3);
		Beneficios benef4 = new Beneficios(null, new BigInteger("21651335820160727"), "5512721310", 341, spf.parse("25/06/2010"), 32, con4, c4);
		benef.saveAll(Arrays.asList(benef1, benef2, benef3, benef4));

	}

}
