<template>
  <main>
    <div class="home">
      <h1>Amigo Secreto 🎁</h1>

      <PersonForm :onAdd="addPerson" />
      <PersonList
        :persons="persons"
        :onDelete="removePerson"
        :onUpdate="updatePerson"
      />

      <button @click="draw">Sortear</button>
    </div>
  </main>
</template>

<style scoped>
main {
  padding: 0;
  margin: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100dvh;
  background-color: #121212;
}
.home {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  width: 700px;
  gap: 20px;
  padding: 50px 0;
  font-family: Arial, sans-serif;
  border: 2px solid black;
  border-radius: 10px;

  background-color: #f9f9f9;
}

button {
  background-color: #4caf50;
  color: white;

  height: 35px;
  width: 150px;

  margin-left: 10px;
  padding: 5px;

  border: none;
  border-radius: 5px;

  cursor: pointer;

  font-size: 16px;
  font-family: "Geologica", sans-serif;
}
</style>

<script>
import api from "../services/api";
import PersonForm from "../components/PersonForm/index.vue";
import PersonList from "../components/PersonList/index.vue";

export default {
  components: { PersonForm, PersonList },
  data() {
    return {
      persons: [],
    };
  },
  mounted() {
    this.loadPersons();
  },
  methods: {
    async loadPersons() {
      const res = await api.get("/persons");
      this.persons = res.data;
    },
    async addPerson(person) {
      await api.post("/persons", person);
      this.loadPersons();
    },
    async removePerson(id) {
      await api.delete(`/persons/${id}`);
      this.loadPersons();
    },
    async updatePerson(id, updated) {
      await api.put(`/persons/${id}`, updated);
      this.loadPersons();
    },
    async draw() {
      await api.post("/persons/draw");
      alert("Sorteio realizado! Emails enviados (veja no Ethereal).");
    },
  },
};
</script>
