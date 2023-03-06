function registerButtonClickedHandler(buttonId, eventHandler) {
    document.getElementById(buttonId).addEventListener('click', eventHandler);
}

function renderAddressesData(data) {
    const table = getClearTable('addresses');
    renderText('fetchAddressesInfo', data["_links"]["self"].href);
    data["_embedded"]["addresses"].forEach(
        address => appendRow(
            table,
            address['addressName'],address['streetNumber'],address['streetName'],
            address['aptNumber'],address['city'],address['state'],address['zipCode']
        )
    )
}

function onFetchAddressesButton() {
    fetchData('/addresses')
        .then(renderAddressesData);
}

function init() {

    registerButtonClickedHandler(
        'fetchCustomersButton',
        onFetchCustomersButton
    );

    registerButtonClickedHandler(
        'fetchAddressesButton',
        onFetchAddressesButton
    )
}


function onFetchCustomersButton() {
    fetchData('/customers')
        .then(renderCustomersData);
}

function getClearTable(tableId) {
    const table = document.getElementById(tableId);
    for (let i = table.rows.length-1; i > 0; i++)
        table.deleteRow(i);
    return table;
}

function renderText(spanId, text) {
    document.getElementById(spanId).innerText = text;
}

function appendRow(table, ...values) {
    let row = table.insertRow();
    values.forEach(value => {
        let cell = row.insertCell();
        let textNode = document.createTextNode(value);
        cell.appendChild(textNode);
    })
}

function renderCustomersData(data) {
    const table = getClearTable('customers');
    renderText('fetchCustomerInfo',data["_links"]["self"].href);

    data["_embedded"]["customers"].forEach(
        customer => appendRow(
            table,
            customer['code'],customer['firstName'],customer['lastName']
        )
    )
}

function fetchData(endPoint) {
    return fetch(endPoint)
        .then(data => data.json());
}

document.addEventListener("DOMContentLoaded",init);

