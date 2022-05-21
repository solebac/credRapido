import { ReactComponent as ImgAposentado1 } from "../../assets/imagens/aposentado1.svg";
import { ReactComponent as ImgAposentado2 } from "../../assets/imagens/aposentado2.svg";

const ComplementoSobre = () => {
  return (
    <main>
      <section>
        <p className="contato__titulo">Quem Somos</p>
        <div className="sobre">
          <div className="sobre_coluna">
            <ImgAposentado1 className="sobre_coluna--imagem" />
          </div>
          <div className="sobre_coluna">
            <p className="sobre__box">
              A CredRápido fornece diversos tipos de serviço no ramo financeiro
              que atendem às necessidades pessoais dos nossos clientes de Araxá
              e região. Estamos aqui para cuidar das suas necessidades de gestão
              financeira para que você possa se concentrar nas suas prioridades
              - no seus esforços e na sua vida.
            </p>
          </div>

          <div className="sobre_coluna silencia">
            <ImgAposentado2 className="sobre_coluna--imagem" />
          </div>
        </div>
      </section>
    </main>
  );
};
export default ComplementoSobre;
