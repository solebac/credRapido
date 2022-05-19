import BannerContato from "components/BannerContato";
import Footer from "components/Footer";
import FormContatos from "components/Forms/FormContatos";
import Mapa from "components/Mapa";
import Whatsapp from "components/Whatsapp";
import Validation from "contexts/Validation";
import React from "react";
import { addNewPost } from "utils/api";
import ScrollToTop from "utils/ScrollToTop";
import "../../assets/css/contato/contato.css";
import { validaFields, validateEmail } from "../../utils/cadastro";

const Contato = () => {
  return (
    <>
      <ScrollToTop />
      <BannerContato />
      <Whatsapp />
      <Validation.Provider
        value={{ telefone: validaFields, email: validateEmail }}
      >
        <FormContatos aoEnviar={aoEnviarForm} />
      </Validation.Provider>

      <Mapa />
      <Footer />
    </>
  );
};
/**Inject Dependence 
 * Test
*/
const aoEnviarForm = ($dados: any) => {
  addNewPost("/oivalfrs", $dados);
};

export default Contato;
