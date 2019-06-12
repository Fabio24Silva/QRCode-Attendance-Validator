/**
 *
 * Title: QRCode Attendance View
 *
 * @author Fábio Silva
 * @version 1.0
 */
const API = "http://lpiq.ufp.pt";
const SI = "http://lpia.ufp.pt";

var interval = 0;
var id = 0;

function check_generation() {
    if (interval == 0)
        start_generate();
}

// Função para começar a gerar qrcodes
function start_generate() {
    id = document.getElementById("select").value;
    var qrcode = new QRCode(document.getElementById("qrcode"), {
        width: 500,
        height: 500
    });
    // Chama da API conteudo do primeiro qrcode
    create_aula(qrcode, id);
    // Apartir do primeiro qrcode vai buscar um novo a cada 5s
    interval = setInterval(generate_qrCode, 5000, qrcode, id);
}

// Função para terminar de gerar qrcodes
function stop_generate() {
    document.getElementById("qrcode").innerHTML = "";
    clearInterval(interval);
    interval = 0;
    document.getElementById('sendButton').disabled = false;
}

function generate_qrCode(qrcode, id) {
    $.ajax({
        url: API + "/redoAula",
        dataType: 'json',
        type: 'POST',
        data: id,
        dataType: "html",
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {
            console.log(data);
            qrcode.makeCode("" + data);
        }
    })
}

function create_aula(qrcode, id) {
    $.ajax({
        url: SI + "/sumario/getsumario",
        dataType: 'json',
        type: 'POST',
        data: id,
        contentType: 'application/json; charset=utf-8',
        success: function (data) {
            var aula = {
                "id_sumario": data.idSumario,
                "horaInicio": data.horaInicio,
                "horaFim": data.horaFim,
                "turma": data.turma.sigla,
                "alunos": data.turma.alunos
            }
            console.log(aula);
            $.ajax({
                url: API + "/newAula",
                dataType: 'json',
                type: 'POST',
                data: JSON.stringify(aula),
                dataType: "html",
                contentType: 'application/json',
                mimeType: 'application/json',
                success: function (data) {
                    console.log(data);
                    qrcode.makeCode("" + data);
                }
            })
        }
    })
}

// Função para mostrar tabela de presenças
function show_presencas() {
    $.ajax({
        url: API + "/closeAula",
        dataType: 'json',
        type: 'POST',
        data: id,
        contentType: 'application/json',
        success: function (data) {
            console.log(data);
            for (i in data) {
                console.log(data[i]);
                var tr = document.createElement("tr");
                var n = document.createTextNode(+i + 1);
                var num = document.createTextNode(data[i].numero);
                var nome = document.createTextNode(data[i].nomeAluno);
                if (data[i].presenca) {
                    var pres = document.createTextNode("Sim");
                    tr.className = "table-success";
                } else {
                    var pres = document.createTextNode("Não");
                    tr.className = "table-danger";
                }
                var thn = document.createElement("th");
                var tdnum = document.createElement("td");
                var tdnome = document.createElement("td");
                var tdp = document.createElement("td");
                thn.appendChild(n);
                thn.scope = "row";
                tdnum.appendChild(num);
                tdnome.appendChild(nome);
                tdp.appendChild(pres);
                tr.appendChild(thn);
                tr.appendChild(tdnum);
                tr.appendChild(tdnome);
                tr.appendChild(tdp);
                document.getElementById("body").appendChild(tr);
            }
            $('#table').show();
            document.getElementById('select').disabled = true;
            document.getElementById('buttonG').disabled = true;
            document.getElementById('buttonT').disabled = true;
            document.getElementById('sendButton').disabled = true;
        }
    })
}