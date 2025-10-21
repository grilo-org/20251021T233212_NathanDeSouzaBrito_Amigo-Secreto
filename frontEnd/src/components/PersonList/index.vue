<template>
  <ul>
    <li v-for="p in persons" :key="p.id">
      <div v-if="editId === p.id">
        <input v-model="editForm.name" placeholder="Nome" />
        <input v-model="editForm.email" placeholder="Email" />
        <button @click="saveEdit(p.id)">Salvar</button>
        <button @click="cancelEdit">Cancelar</button>
      </div>
      <div class="textNames" v-else>
        {{ p.name }} - {{ p.email }}
        <button @click="startEdit(p)">Editar</button>
        <button @click="onDelete(p.id)">Remover</button>
      </div>
    </li>
  </ul>
</template>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Geologica:wght@100..900&display=swap");
@import url("https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap");

ul {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 25px;
  border-top: 2px solid black;
  border-bottom: 2px solid black;
  list-style: none;
  padding-left: 0;

  text-align: center;
}

.textNames {
  display: flex;
  flex-direction: row;

  font-family: "Geologica", sans-serif;
  font-size: 15px;
  font-weight: 400;
  margin: 5px;
}

button {
  background-color: #4caf50;
  color: white;

  height: auto;

  margin-left: 10px;
  padding: 5px;

  border: none;
  border-radius: 5px;

  cursor: pointer;

  font-size: 12px;
  font-family: "Geologica", sans-serif;
}
</style>

<script>
export default {
  props: ["persons", "onDelete", "onUpdate"],
  data() {
    return {
      editId: null,
      editForm: { name: "", email: "" },
    };
  },
  methods: {
    startEdit(person) {
      this.editId = person.id;
      this.editForm = { name: person.name, email: person.email };
    },
    cancelEdit() {
      this.editId = null;
      this.editForm = { name: "", email: "" };
    },
    saveEdit(id) {
      this.onUpdate(id, this.editForm);
      this.cancelEdit();
    },
  },
};
</script>
