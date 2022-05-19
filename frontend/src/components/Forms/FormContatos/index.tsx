import Validation from "contexts/Validation";
import React, { useContext, useEffect, useState } from "react";
import { BASE_URL } from "utils/requests";

const FormContatos = ({ aoEnviar }: any) => {
  const validacoes = useContext(Validation);
  //Forma opcional.: const aoEnviar = $props.aoEnviar;
  const [erros, setErros] = useState({ msg: { valido: true, texto: "" } });
  const [receber, setReceber] = useState(false);
  const [radioWhatsapp, setRadioWhatsapp] = useState(true);
  const [radioTelefone, setRadioTelefone] = useState(false);
  const [radioEmail, setRadioEmail] = useState(false);
  const [msg, setMsg] = useState("");
  const [telefone, setTelefone] = useState("");
  const [assunto, setAssunto] = useState("");
  /**1a Forma simples */
  const [nome, setNome] = useState("");
  /**2a Forma extensa */
  const arr = useState("");
  const email = arr[0];
  const setEmail = arr[1];

  /**Event-Handle any TypeScript*/
  function handleChange(event: any) {
    /*console.log($event.target.value);*/
    setMsg(event.target.value);
  }

  const [test, setTest] = useState(0);

  useEffect(() => {
    document.title += test;
  }, [test]);

  function possoEnviar() {
    //https://stackoverflow.com/questions/16174182/typescript-looping-through-a-dictionary
    let valida = true;
    Object.entries(erros).forEach(([key, value]) => {
      if (key === "valido") {
        if (!value) {
          valida = false;
        }
      }
    });

    return valida;
  }

  const handlerSubmit = async function (event: any) {
    event.preventDefault();

    if (true) {
      const header = new Headers();
      header.append("Content-Type", "application/json");
      header.append("Access", 'application/json"');
      header.append("Access-Control-Allow-Origin", "*");

      const rawResponse = await fetch(`${BASE_URL}/api/sendjs`, {
        method: "POST",
        headers: header,
        body: JSON.stringify({
          nome,
          email,
          assunto,
          msg,
          telefone,
          radioEmail,
          radioTelefone,
          radioWhatsapp,
          receber,
        }),
      });
      const content = await rawResponse.json();

      console.log(content);
    } else {
      console.log("Campos com validação falha...!");
    }
  };

  return (
    <section className="contato">
      <legend className="contato__titulo">Fale conosco</legend>
      <legend className="contato__subtitulo">
        Você pode esclarecer todas as suas dúvidas sobre nossos produtos e
        serviços.
      </legend>
      <h1>{test}</h1>
      <button
        onClick={() => {
          setTest(test + 1);
          console.log(test);
        }}
      >
        Contador
      </button>
      <form className="contato__form" onSubmit={handlerSubmit}>
        <fieldset>
          <label htmlFor="nomeSobrenome" className="contato__etiqueta">
            Nome e sobrenome
          </label>
          <input
            value={nome}
            onChange={(event) => {
              let tmpNome = event.target.value;
              if (tmpNome.length > 12) {
                tmpNome = tmpNome.substring(0, 12);
              }
              setNome(tmpNome);
            }}
            type="text"
            id="nomeSobrenome"
            name="nomeSobrenome"
            className="contato__form--input-padrao"
            required
          />
          <label htmlFor="email" className="contato__etiqueta">
            Email
          </label>
          <input
            value={email}
            onChange={(event) => {
              setEmail(event.target.value);
            }}
            onBlur={(event) => {
              const { name, value } = event.target;
              if (!validacoes[name](value)) {
                return;
              }
            }}
            type="email"
            id="email"
            name="email"
            className="contato__form--input-padrao"
            required
            placeholder="seuemail@dominio.com"
          />
          <label htmlFor="telefone" className="contato__etiqueta">
            Telefone
          </label>
          <input
            value={telefone}
            onChange={(event) => {
              setTelefone(event.target.value);
            }}
            type="tel"
            id="telefone"
            name="telefone"
            className="contato__form--input-padrao"
            required
            placeholder="(xx)xxxxx-xxxx"
            onBlur={(event) => {
              const { name, value } = event.target;
              const ehValido = validacoes[name](value);
              setErros(ehValido);
            }}
          />
          <label htmlFor="assunto" className="contato__etiqueta">
            Assunto
          </label>
          <input
            value={assunto}
            onChange={(event) => {
              setAssunto(event.target.value);
            }}
            type="text"
            id="assunto"
            name="assunto"
            className="contato__form--input-padrao"
            required
          />
          <label htmlFor="mensagem" className="contato__etiqueta">
            Mensagem
          </label>
          <textarea
            value={msg}
            onChange={handleChange}
            name="mensagem"
            id="mensagem"
            rows={6}
            className="contato__form--input-padrao"
          ></textarea>

          <fieldset>
            <legend className="contato__etiqueta">
              Como prefere o nosso contato?
            </legend>
            <label htmlFor="radio-email" className="contato__etiqueta">
              <input
                onChange={(event) => {
                  setRadioEmail(event.target.checked);
                }}
                type="radio"
                name="contato"
                checked={radioEmail}
                id="radio-email"
                placeholder="Email"
              />
              Email
            </label>
            <label htmlFor="radio-telefone" className="contato__etiqueta">
              <input
                onChange={(event) => {
                  setRadioTelefone(event.target.checked);
                }}
                type="radio"
                name="contato"
                checked={radioTelefone}
                id="radio-telefone"
                placeholder="Telfone"
              />
              Telefone
            </label>
            <label htmlFor="radio-whatsapp" className="contato__etiqueta">
              <input
                onChange={(event) => {
                  setRadioWhatsapp(event.target.checked);
                }}
                type="radio"
                name="contato"
                checked={radioWhatsapp}
                id="radio-whatsapp"
                placeholder="WhatsApp"
              />
              WhatsApp
            </label>
          </fieldset>

          <fieldset>
            <legend className="contato__etiqueta">
              Qual horário prefere ser atendido?
            </legend>
            <select id="preferencial">
              <option value="">Manhã</option>
              <option value="">Tarde</option>
              <option value="">Noite</option>
            </select>
          </fieldset>

          <label className="checkboks contato__etiqueta" htmlFor="receber">
            <input
              onChange={(event) => {
                setReceber(event.target.checked);
              }}
              type="checkbox"
              id="receber"
              checked={receber}
            />
            Gostaria de receber nossas novidades por email?
          </label>

          <input type="submit" value="Enviar" className="enviar" />
        </fieldset>
      </form>
    </section>
  );
};

export default FormContatos;
