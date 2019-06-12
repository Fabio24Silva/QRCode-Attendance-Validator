import 'package:flutter/material.dart';
import 'package:flutter_ufp/pages/QrReaderPage.dart';

/**
 *
 * Title: QRCode Reader
 *
 * @author Fábio Silva 
 *         Daniel Pinto
 *         João Caçote
 * @version 1.0
 */
class LoginPage extends StatefulWidget {
  @override
  _LoginPage createState() => _LoginPage();
}

class _LoginPage extends State<LoginPage> {
  final formKey = new GlobalKey<FormState>();
  String _studentID;
  String _password;

  @override
  Widget build(BuildContext context) {
    // Retorna um novo Hero, ou seja, retorna-me uma widget de uma imagem/logo
    Widget _showlogo() {
      return new Hero(
        tag: 'hero',
        child: CircleAvatar(
          backgroundColor: Colors.transparent, // BackGround Transparente
          radius: 100.0, // Altura/Largura da imagem
          child: Image.asset('assets/images/ufp.png'), // Localização da Imagem
        ),
      );
    }

    Widget _showstudentnumber() {
      return new TextFormField(
        maxLines: 1,
        autofocus: false,
        // Sem focus neste input
        keyboardType: TextInputType.number,
        // Teclado direccionado para inserção de números
        style: new TextStyle(fontSize: 18.0, color: Colors.black),
        // Tamanho e Cor de Texto
        decoration: new InputDecoration(
          hintText: 'Número de Aluno',
          hintStyle: TextStyle(fontSize: 18.0, color: Colors.black),
          contentPadding: EdgeInsets.fromLTRB(10.0, 5.0, 10.0, 5.0),
          // Padding do Texto
          icon: new Icon(
            Icons.account_circle,
            color: Colors.green[900],
          ),
        ),
        onSaved: (val) => this._studentID = val,
        validator: (val) => val.length == 0 ? 'Insira Número de Aluno' : null,
      );
    }

    Widget _showpassword() {
      return new TextFormField(
        maxLines: 1,
        obscureText: true,
        // Mascarar o texto
        autofocus: false,
        // Sem focus neste input
        style: new TextStyle(fontSize: 18.0, color: Colors.black),
        // Tamanho e Cor de Texto
        decoration: new InputDecoration(
            hintText: 'Password',
            hintStyle: TextStyle(fontSize: 18.0, color: Colors.black),
            contentPadding: EdgeInsets.fromLTRB(10.0, 5.0, 10.0, 5.0),
            // Padding do Texto
            icon: new Icon(
              Icons.lock,
              color: Colors.green[900],
            )),
        onSaved: (val) => this._password = val,
        validator: (val) => val.length == 0 ? 'Insira palavra-passe' : null,
      );
    }

    void _submit() {
      final form = formKey.currentState;
      print(FormField);
      if (form.validate()) {
        form.save();
        Navigator.pushReplacement(
            context,
            MaterialPageRoute(
              builder: (BuildContext context) => QrReaderPage(
                    studentID: _studentID,
                  ),
            ));
      }
    }

    Widget _showbutton() {
      return Padding(
        padding: EdgeInsets.symmetric(vertical: 16.0),
        child: new RaisedButton(
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(25),
          ),
          onPressed: _submit,
          padding: EdgeInsets.all(12),
          color: Colors.green[900],
          child: Text('Log In', style: TextStyle(color: Colors.white)),
        ),
      );
    }

    return Scaffold(
        backgroundColor: Colors.white,
        body: Center(
            child: new Form(
          key: formKey,
          child: ListView(
            shrinkWrap: true,
            padding: EdgeInsets.only(left: 25.0, right: 25.0),
            children: <Widget>[
              _showlogo(),
              SizedBox(height: 50.0),
              _showstudentnumber(),
              SizedBox(height: 35.0),
              _showpassword(),
              SizedBox(height: 50.0),
              _showbutton(),
            ],
          ),
        )));
  }
}
