// Devuelve un json como Promesa
function solicitud(url, objeto) {
    // 1. Crea cabeceras para enviar y recibir json
    let cabeceras = {
        'Accept': 'application/json'
        , 'Content-Type': 'application/json'
    };

    let request;
    if (objeto === undefined) {
// Método Get
        // 2. No enviar nada
        // 3. Crear la petición (el archivo a mandar)
        request = {
            method: 'get',
            headers: cabeceras
        };
    } else {
// Método Post
        // 2. SERIALIZARLO, si es necesario
        let objetoSerializado;
        if (typeof objeto === "string"){
            objetoSerializado = objeto;
        } else {
            objetoSerializado = JSON.stringify(objeto);
        }
        // 3. Crear la petición (el archivo a mandar)
        request = {
            method: 'post',
            headers: cabeceras,
            body: objetoSerializado
        };
    }

    // 4. Realizar la petición (mandar el request a la url) y devuelve un json como Promesa
    return fetch(url, request)
        .then(resp => { // Recepción de respuesta
            if (resp.ok) {
                return resp.json(); // Devolvemos el json
            } else {
                throw new Error(`HTTP error! Status: ${resp.status}`);
            }
        });
}

//...
/* Modo de empleo */
// Post: Hacer la petición a la URL enviando un objeto y, lanzar las funciones presentarResultado o procesarError
    solicitud(URL, objeto)
        .then( presentarResultado )
        .catch( procesarError );


// Get: Hacer la petición codificando los datos como argumento
    solicitud(URL)
        .then( presentarResultado )
        .catch( procesarError );
