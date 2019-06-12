import 'package:flutter/material.dart';
import 'package:barcode_scan/barcode_scan.dart';
import 'package:flutter/services.dart';
import 'package:http/http.dart' as http;
import 'dart:async';
import 'dart:convert';
import 'package:flutter_udid/flutter_udid.dart';

/**
 *
 * Title: QRCode Reader
 *
 * @author Fábio Silva 
 *         Daniel Pinto
 *         João Caçote
 * @version 1.0
 */
class QrReaderPage extends StatefulWidget {
  final String studentID;

  QrReaderPage({@required this.studentID});
  @override
  QrReaderPageState createState() {
    return new QrReaderPageState(studentID);
  }
}

class QrReaderPageState extends State<QrReaderPage> {
  String studentID;
  QrReaderPageState(this.studentID);
  String result = "Leitura de QRCode UFP"; // Texto da página principal

  Future _scanQR() async {
    try {
      String qrResult = await BarcodeScanner.scan();
      String udid =
          await FlutterUdid.udid; // Espera que o QRCode acaba de ser lido
      final Map<String, dynamic> data = {
        'qrcode': qrResult,
        'numeroDeAluno': studentID,
        'phoneId': udid
      };
      http
          .post('http://lpiq.ufp.pt/validate',
              headers: {"Content-Type": "application/json"},
              body: json.encode(data))
          .then((http.Response response) {
        final bool responseData = json.decode(response.body);
        setState(() {
          if (responseData) {
            result = "Presença validada";
          } else {
            result = "Presença falhada";
          }
        });
      });
    } on PlatformException catch (ex) {
      if (ex.code == BarcodeScanner.CameraAccessDenied) {
        setState(() {
          result = "Permissões para aceder à camara rejeitadas";
        });
      } else {
        setState(() {
          result = "Erro $ex";
        });
      }
    } on FormatException {
      setState(() {
        result = "Voltaste atrás sem ler nenhum QRCode";
      });
    } catch (ex) {
      setState(() {
        result = "Erro $ex";
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Text(
          result,
          style: new TextStyle(
              fontSize: 30.0,
              fontWeight: FontWeight.bold,
              color: Colors.green[900]),
        ),
      ),
      floatingActionButton: FloatingActionButton.extended(
        backgroundColor: Colors.green[900],
        icon: Icon(Icons.camera_alt),
        label: Text("Scan"),
        onPressed: _scanQR, // Liga o leitor de QRCodes
      ),
      floatingActionButtonLocation: FloatingActionButtonLocation.centerFloat,
    );
  }
}
