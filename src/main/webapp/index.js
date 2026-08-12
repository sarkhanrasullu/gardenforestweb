function $(elementId) {
    return document.getElementById(elementId);
}

function insertStudent() {

    const form = new URLSearchParams();

    form.append("action", 'insert');
    form.append("name", document.getElementById("insertName").value);
    form.append("surname", document.getElementById("insertSurname").value);
    form.append("age", document.getElementById("insertAge").value);
    form.append("scholarship", document.getElementById("insertScholarship").value);
    form.append("universityId", document.getElementById("insertUniversityId").value);

    console.log(JSON.stringify(form));
    var doOnSuccess = function() {
        location.reload();
    };

    fetch("students", {
        method: "POST",
        body: form
    })
        .then(doOnSuccess);
}

function openUpdateModal(id, name, surname, age, scholarship, universityId) {

    updateId.value = id;
    updateName.value = name;
    updateSurname.value = surname;
    updateAge.value = age;
    updateScholarship.value = scholarship;
    updateUniversityId.value = universityId;

    new bootstrap.Modal(document.getElementById("updateModal")).show();
}

function updateStudent() {
    const form = new URLSearchParams();

    form.append("id", updateId.value);
    form.append("name", updateName.value);
    form.append("surname", updateSurname.value);
    form.append("age", updateAge.value);
    form.append("scholarship", updateScholarship.value);
    form.append("universityId", updateUniversityId.value);
    form.append("action", 'update');

    fetch("students", {
        method: "POST",
        body: form
    }).then(() => location.reload());
}

function openDeleteModal(id) {

    deleteId.value = id;

    new bootstrap.Modal(document.getElementById("deleteModal")).show();
}

function deleteStudent() {

    const form = new URLSearchParams();

    form.append("id", deleteId.value);
    form.append("action", 'delete');

    fetch("students", {
        method: "POST",
        body: form
    }).then(() => location.reload());
}