let searchFlightInputField = document.getElementById('searchFlightInput');

function checkForFlightResultsFound(inputField) {
    let enteredCountry = document.getElementById('search_flight_input').value;
    ajaxFlightsCall(enteredCountry);

    let resultsDataTable = document.getElementById('results_data');
    observer.observe(resultsDataTable, {childList: true, subtree: true});
}


let observer = new MutationObserver(function(mutations) {
    mutations.forEach(function(mutation) {
        let resultsFound = mutation.target.rows.length;

        document.getElementById('results_found').innerText = resultsFound + ' results found';
        checkForEnteredText(mutation.target);
        observer.disconnect();
    });
});


function checkForEnteredText(resultsDataTable) {
    let resultsFoundCount = document.getElementById('results_found');
    let searchFlightInput = document.getElementById('search_flight_input');

    if(!searchFlightInput.value.replace(/ /g, '').length || !resultsDataTable.hasChildNodes()) {
        resultsFoundCount.classList.add('hide');
        if(resultsDataTable.classList.contains('table_not_empty')) {
            resultsDataTable.classList.remove('table_not_empty');
        }

    } else {
        resultsFoundCount.classList.remove('hide');
        if(!resultsDataTable.classList.contains('table_not_empty')) {
            resultsDataTable.classList.add('table_not_empty');
        }

    }
}


function ajaxFlightsCall(countryName, getResponse) {
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == XMLHttpRequest.DONE) {
            if (xhr.status == 200) {

                let response = JSON.parse(xhr.responseText);
                let resultsDataTable = document.getElementById('results_data');

                while(resultsDataTable.hasChildNodes()) {
                    resultsDataTable.removeChild(resultsDataTable.firstChild);
                }

                for(let i = 0; i < response.length; i++) {
                    let newTableRow = document.createElement('tr');
                    let simpleElementData = response[i].split(',');

                    for(let j = 0; j < simpleElementData.length; j++) {
                        let newTableCell = document.createElement('td');
                        newTableCell.innerText = simpleElementData[j];

                        newTableRow.appendChild(newTableCell);
                    }

                    resultsDataTable.appendChild(newTableRow);
                }
                window.scrollTo(0, document.body.scrollHeight);

            } else {
                document.getElementById('foundResults').textContent = 'Error: ' + xhr.status;
            }
        }
    };

    xhr.open('GET', '/home/request/getPresentArrivalFlights?countryName=' + countryName, true);
    xhr.send(null);
}
