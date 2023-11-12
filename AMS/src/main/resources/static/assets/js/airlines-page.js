const filterOptions = document.querySelectorAll('#filterPanel .option input[type="checkbox"]');
const airlinesData = document.getElementsByClassName('airlines_data_parser');
const airlinesClasses = ['FIRST CLASS', 'BUSINESS CLASS', 'PREMIUM ECO CLASS', 'ECONOMY CLASS'];
const checkerDeselectValue = 'Deselect All';
const checkerSelectValue = 'Select All';
const tabColors = new Map([
    ['notSelected', '#7cced0'],
    ['selected', '#00efff']
]);


window.onload = function() {
    setIdOnEachAirlineNameElement();
    checkAllCheckboxes();
}


function checkAllCheckboxes() {
    toggleAllSwitcherOptions(filterOptions[filterOptions.length - 1]);
}


function setIdOnEachAirlineNameElement() {
    document.querySelectorAll('.airline_name_block p').forEach(
        el => {
            el.setAttribute('id', el.textContent.replace(/ /g, '_'));
        }
    );
}


function markCheckedOption(btn) {
    if(btn.checked) {
        btn.parentNode.style.backgroundColor = tabColors.get('selected');
    } else {
        btn.parentNode.style.backgroundColor = tabColors.get('notSelected');
    }

    filterAirlinesToDisplay();
}


function toggleAllSwitcherOptions(btn) {
    const manipulateAllItemText = btn.parentNode.querySelector('#manipulateAllItemText');

    if(manipulateAllItemText.innerText == checkerSelectValue) {
        for(let j = 0; j < filterOptions.length; j++) {
            filterOptions[j].checked = 'true';
            markCheckedOption(filterOptions[j]);
        }
        manipulateAllItemText.innerText = checkerDeselectValue;
        return;
    }

    if(manipulateAllItemText.innerText == checkerDeselectValue) {
        for(let j = 0; j < filterOptions.length; j++) {
            filterOptions[j].checked = '';
            markCheckedOption(filterOptions[j]);
        }
        manipulateAllItemText.innerText = checkerSelectValue;
    }
}


document.querySelector('#filterPanel').addEventListener('change', function (){
    checkIfAllCheckboxesAreChecked();
});


function checkIfAllCheckboxesAreChecked() {
    let checkedOptions = 0;
    let allOptions = filterOptions.length - 1;
    for(let i = 0; i < allOptions; i++) {
        if(filterOptions[i].checked) {
            checkedOptions++;
        }
    }

    let noDataElement = document.createElement('p');
    noDataElement.textContent = "No airline class chosen";
    noDataElement.setAttribute('id', 'no_data');

    let manipulateAllFilterItem = document.getElementById('manipulateAllItemText');
    let airlinesPanel = document.getElementById('airlines_panel');
    if(checkedOptions >= allOptions) {
        manipulateAllFilterItem.textContent = checkerDeselectValue;
        manipulateAllFilterItem.parentNode.style.backgroundColor = tabColors.get('selected');

        if(document.querySelector('#airlines_panel #no_data') !== null) {
            airlinesPanel.removeChild(document.querySelector('#airlines_panel #no_data'));
        }

    } else if(0 < checkedOptions && checkedOptions < allOptions) {
        manipulateAllFilterItem.textContent = checkerSelectValue;
        manipulateAllFilterItem.parentNode.style.backgroundColor = tabColors.get('notSelected');

        if(document.querySelector('#airlines_panel #no_data') !== null) {
            airlinesPanel.removeChild(document.querySelector('#airlines_panel #no_data'));
        }

    } else {
        manipulateAllFilterItem.textContent = checkerSelectValue;
        manipulateAllFilterItem.parentNode.style.backgroundColor = tabColors.get('notSelected');

        if(checkedOptions === 0) {
            airlinesPanel.appendChild(noDataElement);
        }
    }
}


function filterAirlinesToDisplay() {
    let namesClassesMap = new Map();
    for(let i = 0; i < airlinesData.length; i++) {
        let parts = airlinesData[i].textContent.split('|');
        namesClassesMap.set(parts[0], parts[1]);
    }

    let doFurtherCheck = true;
    for(let [key,value] of namesClassesMap) {

        if(document.getElementById('first_cls_check').checked && doFurtherCheck) {
            doFurtherCheck = !value.includes(airlinesClasses[0]);
        }

        if(document.getElementById('business_cls_check').checked && doFurtherCheck) {
            doFurtherCheck = !value.includes(airlinesClasses[1]);
        }

        if(document.getElementById('premium_eco_cls_check').checked && doFurtherCheck) {
            doFurtherCheck = !value.includes(airlinesClasses[2]);
        }

        if(document.getElementById('eco_check').checked && doFurtherCheck) {
            doFurtherCheck = !value.includes(airlinesClasses[3]);
        }

        let formattedKeyId = key.replace(/ /g, '_');
        if(doFurtherCheck) {
            document.getElementById(formattedKeyId).parentNode.style.display = 'none';
        } else {
            document.getElementById(formattedKeyId).parentNode.style.display = 'grid';
        }

        doFurtherCheck = true;
    }

}

