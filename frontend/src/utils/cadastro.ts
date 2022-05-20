const validaFields = ( $fields : string): {} => {
  if ($fields.length < 11) {
      return {
        valido: false,
        texto: "Telefone deve conter no mínimo 11 digitos...!",
      };
    }
    return { valido: true, texto: "" };
}

// https://stackoverflow.com/questions/46155/whats-the-best-way-to-validate-an-email-address-in-javascript
function validateEmail(email: any) {
  return String(email)
    .toLowerCase()
    .match(
      /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    );
}

export {validaFields, validateEmail}