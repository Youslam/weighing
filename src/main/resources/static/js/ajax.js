/**
 * @author Robert Wilk
 * Created on 1/20/2016.
 */

// Begin Something modal population and submit functions
var url = "/vehicle/";
var editModalTarget = url + "loadEntity/";
var tableTarget = url + "loadVehicleTable/";

// Build the url for the Ajax request for Something.
function showEditModal(index) {
    var editUrl = editModalTarget + index;
    loadEntity(editUrl);
}

function showDeleteModal(index) {
    $('#delete-id').val(index);
}

// Ajax request for Something to populate the modal form.
function loadEntity(url) {
    $.getJSON(url, {}, function (data) {
        populateModal(data);
    });
}

// Assign the data values to the modal form.
function populateModal(data) {
    $('#matricule').val(data.matricule);
    $('#type').val(data.type);
    $('#brand').val(data.brand);
    $('#model').val(data.model);
    $('#maxload').val(data.maxload);
}

function clearModal() {
	$('#matricule').val('');
    $('#type').val('');
    $('#brand').val('');
    $('#model').val('');
    $('#maxload').val('');
}

function closeModal(name) {
    $(name).modal('toggle');
}

function clearAndCloseModal(name) {
    clearModal();
    closeModal(name);
}

// POST the edits to Something to the server.
function postEdit() {
    var something = $('#edit-form').serialize();
    var editUrl = url + 'update';
    $.post(editUrl, something, function (data) {
        updateTable(data);
    });
    clearAndCloseModal('#umodal');
}

function deleteEntity(entity) {
    var input = $('#delete-id');
    var url = '/' + entity + '/delete/' + input.val();
    $.post(url, function (data) {
        updateTable(data);
    });
    closeModal('#dmodal');
    input.val('');
}

function updateTable(data) {
    $.ajax({
        dataType: "json",
        url: tableTarget,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: 'GET',
        success: function (response) {
            $('#table-body').empty();
            $.each(response, function (i, e) {
                var end = e.id + ");'";
                var edit = "'showEditModal(" + end;
                var del = "'showDeleteModal(" + end;
                var row = $('<tr>').append(
                    $('<td>').text(e.matricule),
                    $('<td>').text(e.type),
                    $('<td>').text(e.brand),
                    $('<td>').text(e.model),
                    $('<td>').text(e.maxload),
                    $('<td>').append(
                        "<a data-toggle='modal' data-target='#umodal' onclick=" +
                        edit + ">Edit</a>"
                    ),
                    $('<td>').append(
                        "<a data-toggle='modal' data-target='#dmodal' onclick=" +
                        del + ">Delete</a>"
                    )
                );
                $('#vehicle-list').append(row);
            });
        }
    });
}
