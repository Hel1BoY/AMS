const selectJobPositionsRadioBtns = document.getElementsByClassName('selectElementRadio');
const tools = ['add', 'edit', 'remove'];
const defaultItemBorderColor = '#86a5ff';
const markItemBorderColors = new Map([
    ['add', ''],
    ['edit', '#ff0'],
    ['remove', '#f00']
]);
const hintMessages = new Map([
     ['add', 'Hint:\u00A0\u00A0Please enter the new job position data and press the \'check\' button to save.'],
     ['edit', 'Hint:\u00A0\u00A0Please select an option which should be edited and press the \'check\' button to save.'],
     ['remove', 'Hint:\u00A0\u00A0Please select an option which should be removed and press the \'check\' button to save.']
]);

let oldJobPositionOnEditMode = null;
let editJobPositionFormSaved = null;
let selectedTool = '';


document.addEventListener('DOMContentLoaded', function() {
   addRadioButtonsToAllJobPositions();
   saveConfiguredEditJobPositionForm();
});


function addRadioButtonsToAllJobPositions() {
    let allPositionsWrappers = document.querySelectorAll('div[id^="job_pos_wrap"]');

    for(let j = 0; j < allPositionsWrappers.length; j++) {
        let wrapper = allPositionsWrappers[j];

        let button = document.createElement('input');
        button.setAttribute('type', 'radio');
        button.setAttribute('class', 'selectElementRadio');
        button.setAttribute('name', 'selectElementRadio');
        button.setAttribute('onchange', 'markAndReturnSelectedJobPosition(); checkForSelectedOptions(this);');
        button.style.width = wrapper.offsetWidth + 'px';
        button.style.height = wrapper.offsetHeight + 'px';
        button.style.zIndex = '2';

        wrapper.insertAdjacentHTML("beforeend", button.outerHTML);
    }
}


function saveConfiguredEditJobPositionForm() {
    let configuredEditJobPositionForm = document.getElementById('editJobPositionForm');
    editJobPositionFormSaved = configuredEditJobPositionForm.cloneNode(true);
}


function changeToolStyleWhenSelected(toolsPanel) {
    let radioButtons = toolsPanel.querySelectorAll('.instruments input[type="radio"].tool_option');
    selectedTool = '';

    for(let i = 0; i < radioButtons.length; i++) {
        let radio = radioButtons[i];
        let toolImg = radio.parentNode.querySelector('img');

        if(radio.checked) {
            toolImg.classList.add('checkedTool');

            if(!selectedTool) {
                selectedTool = tools[i];
            }
        } else {
            toolImg.classList.remove('checkedTool');
        }
    }

    let saveButton = document.getElementById('save');
    if(selectedTool) {
        saveButton.classList.remove('hide');
    }

    revertPageChangesBasedOnTool();
}


function revertPageChangesBasedOnTool() {
    let allJobPositionsPanels = document.querySelectorAll('.job_positions_panel');

    if(selectedTool !== 'add') {
        let addItemForm = document.getElementById('newJobPositionForm');
        if(!addItemForm.classList.contains('hide')) {
            addItemForm.classList.add('hide');
        }
    }
    if(selectedTool !== 'edit') {
        if(oldJobPositionOnEditMode !== null) {
            let editJobPositionForm = document.getElementById('editJobPositionForm');
            let editJobPositionFormId = editJobPositionForm.parentNode.id;
            if(editJobPositionFormId.includes('job_pos_wrap_')) {
                editJobPositionForm.parentNode.replaceChild(oldJobPositionOnEditMode, editJobPositionForm);
                oldJobPositionOnEditMode = null;
            }
            document.getElementById('job_positions_panel_wrapper').insertAdjacentHTML("beforeend", editJobPositionFormSaved.outerHTML);
        }
        allJobPositionsPanels.forEach(el => el.style.borderColor = defaultItemBorderColor);
    }
    if(selectedTool !== 'remove') {
        allJobPositionsPanels.forEach(el => el.style.borderColor = defaultItemBorderColor);
    }

}


function changeHintMessage(toolsParent) {
    let hintMessage = document.getElementById('hint_message');

    if(hintMessage.classList.contains('hide')) {
        hintMessage.classList.remove('hide');
    }

    let classHint = 'hint';
    if(selectedTool === 'add') {
        hintMessage.textContent = hintMessages.get('add');
        hintMessage.classList.add(classHint);
    } else if(selectedTool === 'edit') {
        hintMessage.textContent = hintMessages.get('edit');
        hintMessage.classList.add(classHint);
    } else if(selectedTool === 'remove') {
        hintMessage.textContent = hintMessages.get('remove');
        hintMessage.classList.add(classHint);
    }

}


function addNewJobPosition() {
    let newJobPositionForm = document.getElementById('newJobPositionForm');
    newJobPositionForm.classList.remove('hide');

    window.scrollTo(0, document.body.scrollHeight);
}


function markAndReturnSelectedJobPosition() {
    let buttonPosition;

    for(let i = 0; i < selectJobPositionsRadioBtns.length; i++) {
        let radioButton = selectJobPositionsRadioBtns[i];

        let jobPositionElementWrapper = radioButton.parentNode;

        if(radioButton.checked) {
            jobPositionElementWrapper.style.borderColor = markItemBorderColors.get(selectedTool);
            buttonPosition = i;
        } else {
            jobPositionElementWrapper.style.borderColor = defaultItemBorderColor;
        }
    }

    return buttonPosition;
}


function resizeField(el) {
    el.style.height = 'auto';
    el.style.height = el.scrollHeight + 'px';
}


function submit() {
    if(selectedTool == 'add') {
        let saveNewPositionForm = document.getElementById('newJobPositionForm');
        submitNewJobPositionForm(saveNewPositionForm);
    } else if(selectedTool == 'edit') {
        let editNewPositionForm = document.getElementById('editJobPositionForm');
        submitEditJobPositionForm(editNewPositionForm);
    } else if(selectedTool == 'remove') {
        submitRemoveJobPositionForm();
    }
}


function submitNewJobPositionForm(formForSubmission) {
    let selectContact = formForSubmission.querySelector('select#contactSelect');
    let workingHoursInput = formForSubmission.querySelector('input[name="workingHours"]');
    let workingHoursSelect = formForSubmission.querySelector('select#js_new_working_hours_select');

    workingHoursInput.value = workingHoursSelect.value;
    formForSubmission.action = formForSubmission.action + '/' + selectContact.value;
    formForSubmission.submit();
}


function submitEditJobPositionForm(formForSubmission) {
    let selectContact = formForSubmission.querySelector('select#contactSelect');
    let workingHoursInput = formForSubmission.querySelector('input[name="workingHours"]');
    let workingHoursSelect = formForSubmission.querySelector('select#js_new_working_hours_select');
    let position = getItemIdNumber(formForSubmission.parentNode.id);

    workingHoursInput.value = workingHoursSelect.value;
    formForSubmission.action = formForSubmission.action + '?jobPositionId=' + position + '&contactId=' + selectContact.value;
    formForSubmission.submit();
}


function submitRemoveJobPositionForm() {
    let formRemove = document.createElement('form');
    let formRemoveId = 'removeJobPositionForm';
    formRemove.id = formRemoveId;
    document.getElementById('job_positions_panel_wrapper').insertAdjacentHTML("afterend", formRemove.outerHTML);

    let removePositionForm = document.getElementById(formRemoveId);
    let buttonPosition = markAndReturnSelectedJobPosition();
    let positionId = selectJobPositionsRadioBtns[buttonPosition].parentNode.querySelector('div[id^="job_pos_"]').id;
    let position = getItemIdNumber(positionId);

    removePositionForm.setAttribute('action', '/careers/closePosition/' + position);
    removePositionForm.method = 'post';

    alert('Confirm removing of this job position . . .');
    removePositionForm.submit();
}


function checkForSelectedOptions(radioBtn) {
    if(selectedTool == 'edit') {
        checkForSelectedOptionsOnEdit(radioBtn);
    }
}


function checkForSelectedOptionsOnEdit(radioButton) {
    let jobPositionElement = radioButton.parentNode.querySelector('div[id^="job_pos_"]');

    let editJobPositionForm = document.getElementById('editJobPositionForm');
    editJobPositionForm.style.zIndex = '2';
    editJobPositionForm.querySelector('.job_positions_panel').style.border = 'none';
    radioButton.style.zIndex = '0';

    if(editJobPositionForm.classList.contains('hide')) {
        editJobPositionForm.classList.remove('hide');
    }

    if(oldJobPositionOnEditMode === null) {
        oldJobPositionOnEditMode = jobPositionElement.cloneNode(true);
        jobPositionElement.parentNode.replaceChild(editJobPositionForm , jobPositionElement);

    } else if (jobPositionElement.id != oldJobPositionOnEditMode.id) {
        jobPositionElement.parentNode.replaceChild(editJobPositionForm , jobPositionElement);

        let oldPositionIdNumber = getItemIdNumber(oldJobPositionOnEditMode.id);
        let oldPositionWrapperEl = document.getElementById('job_pos_wrap_' + oldPositionIdNumber);

        oldPositionWrapperEl.querySelector('input.selectElementRadio').style.zIndex = '2';
        oldPositionWrapperEl.insertAdjacentHTML('afterbegin', oldJobPositionOnEditMode.outerHTML);

        oldJobPositionOnEditMode = jobPositionElement.cloneNode(true);
    }

    fillOldDataOnEditMode(editJobPositionForm);
}


function fillOldDataOnEditMode(editJobPositionForm) {
    let oldWorkingHoursValue = oldJobPositionOnEditMode.querySelector('.js_workingHours').textContent;
    let oldContactValue = oldJobPositionOnEditMode.querySelector('.js_contact_info').textContent;

    editJobPositionForm.querySelector('input[name="name"]').value = oldJobPositionOnEditMode.querySelector('.js_positionName').textContent;
    editJobPositionForm.querySelector('textarea[name="requirements"]').value = oldJobPositionOnEditMode.querySelector('.js_requirements').innerText;

    let workingHoursSelectOnEdit = editJobPositionForm.querySelector('select#js_new_working_hours_select');
    for(let i = 0; i < workingHoursSelectOnEdit.length; i++) {
        let option = workingHoursSelectOnEdit[i];

        if(option.text === oldWorkingHoursValue) {
            option.selected = 'selected';
            break;
        }
    }

    let contactsSelectOnEdit = editJobPositionForm.querySelector('select#contactSelect');
    for(let i = 0; i < contactsSelectOnEdit.length; i++) {
        let option = contactsSelectOnEdit[i];

        if(option.text === oldContactValue) {
            option.selected = 'selected';
            break;
        }
    }

}


function getItemIdNumber(str) {
    let strSplit = str.split('_');
    return strSplit[strSplit.length - 1];
}

