import 'package:flutter/material.dart';
import 'package:flutter_ufp/pages/LoginPage.dart';
import 'dart:async';

/**
 *
 * Title: QRCode Reader
 *
 * @author Fábio Silva
 *         Daniel Pinto
 *         João Caçote
 * @version 1.0
 */
void main() => runApp(MaterialApp(
      theme: new ThemeData(
        primarySwatch: Colors.green, // Torna a cor primária da app verde
      ),
      debugShowCheckedModeBanner: false, // Remove banner de debug
      home: MyApp(),
    ));

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() {
    return new _MyAppState();
  }
}

class _MyAppState extends State<MyApp> {
  @override
  void initState() {
    super.initState();
    Future.delayed(
        Duration(seconds: 1), // Após 1s passa do splash screen para o login
        () {
      Navigator.pushReplacement(
          // Faz replace da página atual pela página de login
          context,
          MaterialPageRoute(
            builder: (context) => LoginPage(),
          ));
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: new Image.asset(
            'assets/images/ufp.png'), // Logo da UFP no splash screen
      ),
    );
  }
}
