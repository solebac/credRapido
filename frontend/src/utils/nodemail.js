const mailer = require("nodemailer");

/*module.exports = (email, nome, mensagem, anexo) => {*/
module.exports = (nome,
    email,
    msg,
    telefone,
    radioEmail,
    radioTelefone,
    radioWhatsapp,
    receber) => {
    const smtpTransport = mailer.createTransport({
        service: 'gmail',
        auth: {
            user: 'solebacfrs@gmail.com',
            pass: 'ghmuyvnmpitzamop'
        },tls: {rejectUnauthorized: false}
    })
    
    const mail = {
        from: "solebacfrs@gmail.com",
        to: email,
        subject: `${nome} te enviou uma mensagem`,
        text: msg,
        html: "<b>Opcionalmente, pode enviar como HTML</b>"
    }
    
    /*if(anexo){
        console.log(anexo);
        mail.attachments = [];
        mail.attachments.push({
            filename: anexo.originalname,
            content: anexo.buffer
        })
    }*/
    
    return new Promise((resolve, reject) => {
        smtpTransport.sendMail(mail)
            .then(response => {
                smtpTransport.close();
                return resolve(response);
            })
            .catch(error => {
                smtpTransport.close();
                return reject(error);
            });
    })
}