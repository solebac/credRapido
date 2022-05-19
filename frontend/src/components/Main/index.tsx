import React, { Fragment } from "react";
import Categorias from "./Categorias";
import ListaServices from "./ListaServices";
import Destaques from "./Destaques";
import Team from "./Team";

const Main = () => {
  return (
    <Fragment>
      <ListaServices />
      <Categorias />
      <Destaques />
      <Team />
    </Fragment>
  );
};
export default Main;
