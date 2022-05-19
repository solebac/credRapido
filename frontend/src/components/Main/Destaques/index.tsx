import React from "react";
import '../../../assets/css/components/destaques.css';

const Destaques = () => {
  return (
    <section className="container between">
      <p className="retrato__titulo retrato__titulo--sombra">Destaques</p>

      <article className="container">
        <div className="destaque">
          <p className="destaque__titulo">CredRápido Araxá</p>
          <p className="destaque__subTitulo">
            O apoio financeiro que você esperava, está aqui !
          </p>
          <p className="destaque__texto">
            A CredRápido Araxá fornece aos seus clientes assistência e serviços
            profissionais em Créditos e Empréstimos, permitindo que eles se
            concentrem nos seus negócios e na vida pessoal. Estamos no mercado
            desde 2000 e nossa equipe de Analistas trabalha assiduamente e de
            acordo com os padrões profissionais mais elevados.
          </p>
          <div className="destaque__imagem"></div>
        </div>
      </article>
    </section>
  );
}

export default Destaques;
