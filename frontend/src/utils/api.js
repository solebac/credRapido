import axios from "axios";
import { BASE_URL } from "./requests";
export const api = axios.create({
  baseURL: BASE_URL,
});

export const busca = async (url, setDado) => {
  const reposta = await api
    .get(url)
    .then()
    .catch((error) => console.log(error));
  setDado(reposta.data);
};

/*Seção de Test - Backend
  useEffect(() =>{
    addNewServices(`${BASE_URL}/servicos`)
  },[])   //Para testar verb=post adicionar esse codigo
*/
const newServices = {
  titulo: "Novo Test",
  descricao: "Aqui você encontra as melhores oportunidades de negocio...",
};
export const addNewServices = async (url) => {
  await api
    .post(url, newServices)
    .then((response) => {
      console.log(response.data); //alert();
    })
    .catch((error) => console.log(error));
};

export const addNewPost = async (url, campos) => {
  await api
    .post(url, campos)
    .then((response) => {
      console.log(response.data);
    })
    .catch((error) => console.log(error));
};

/**Não se passa o id=no json */
/*const upServices = {
  titulo: "Novo Test",
  descricao: "Aqui você encontra as melhores oportunidades de negocio...",
};*/

/**
 *   useEffect(() => {
    updateServicos(`${BASE_URL}/servicos/1`);
  }, []); test update...
 */
export const updateServicos = async (url, dados) => {
  await api
    .put(url, dados)
    .then((response) => {
      console.log(response.data);
    })
    .catch();
};

/*
  useEffect(() => {
    deleteServicos(`${BASE_URL}/servicos`);
  }, []);
*/
export const deleteServicos = async (url) => {
  await axios
    .delete(`${url}/2`)
    .then((response) => {
      console.log(response.data);
    })
    .catch((error) => console.log(error));
};
