import React from "react";

const ComplementoServicos = () => {
  return (
    <main>
      <section className="contato">
        <p className="contato__titulo">SERVIÇOS</p>
        <p className="contato__subtitulo">
          Empréstimo pessoal, dinheiro rápido e fácil e sem consulta ao SPC e
          Serasa você encontra aqui!
        </p>
      </section>

      <article className="container between">
        <p className="retrato__titulo retrato__titulo--sombra">
          Empréstimo consignado
        </p>
        <div className="retrato ceiling servicos_card">
          <p className="contato__subtitulo">
            O Crédito consignado é um empréstimo com pagamento indireto, cujas
            parcelas são deduzidas diretamente da folha de pagamento ou
            benefício da pessoa física.
          </p>
        </div>
      </article>

      <article className="container between">
        <p className="retrato__titulo retrato__titulo--sombra">
          Empréstimo Pessoal
        </p>
        <div className="retrato ceiling servicos_card">
          <p className="contato__subtitulo">
            Você pode alivar suas despesas, pagamento de contas ou organizar sua
            vida financeira. Também pode solucionar um imprevisto e até realizar
            sonhos.
          </p>
        </div>
      </article>

      <article className="container between">
        <p className="retrato__titulo retrato__titulo--sombra">
          Empréstimo com débito em conta
        </p>
        <div className="retrato ceiling servicos_card">
          <p className="contato__subtitulo">
            Mais uma modalidade de crédito pessoal. Seu diferencial é o fato do
            valor da parcela da dívida ser descontado automaticamente da conta
            bancária do consumidor. O que pode ser uma vantagem e também uma
            desvantagem dessa linha.
          </p>
        </div>
      </article>

      <article className="container between">
        <p className="retrato__titulo retrato__titulo--sombra">Refinanciamento</p>
        <div className="retrato ceiling servicos_card">
          <p className="contato__subtitulo">
            Nossos profissionais lhe oferecem nada mais é do que trocar um
            contrato de empréstimo antigo por um novo na mesma instituição
            financeira, sendo possível fazer alterações no prazo e valores
            contratados.
          </p>
        </div>
      </article>

      <article className="container between">
        <p className="retrato__titulo retrato__titulo--sombra">Portabilidade</p>
        <div className="retrato ceiling servicos_card">
          <p className="contato__subtitulo">
            Você pode solicitar a transferência de seus empréstimos contratados
            em outros bancos para o seu banco de movimento e ter as parcelas
            debitadas direto em sua folha de pagamento ou em conta.
          </p>
        </div>
      </article>
    </main>
  );
};

export default ComplementoServicos;