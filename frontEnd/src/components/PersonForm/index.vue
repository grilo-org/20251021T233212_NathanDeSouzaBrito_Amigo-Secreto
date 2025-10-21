<template>
  <form @submit.prevent="handleSubmit">
    <div class="textBox">
      <label for="">Nome</label>
      <input v-model="form.name" placeholder="Nome" required />
    </div>
    <div class="textBox">
      <label for="">Email</label>
      <input v-model="form.email" type="email" placeholder="Email" required />
    </div>
    <button type="submit">Adicionar</button>
  </form>
</template>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Geologica:wght@100..900&display=swap");
@import url("https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap");

form {
  display: flex;
  flex-direction: column;
  gap: 10px;
  background-color: lightgray;
  padding: 10px;
  border-radius: 5px;
}

label {
  font-size: 15px;
  font-weight: 400;
  font-family: "Geologica", sans-serif;
}

input {
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 3px;
  height: 30px !important;

  font-family: "Roboto", sans-serif;
  font-size: 13px;
  font-weight: 400;
}

.textBox {
  display: flex;
  flex-direction: column;
  width: 300px;
  gap: 5px;
}

button {
  padding: 10px;
  background-color: #4caf50;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 14px;
  font-weight: bold;
  font-family: "Geologica", sans-serif;
}
</style>

<script>
export default {
  props: ["onAdd"],
  data() {
    return {
      form: { name: "", email: "" },
    };
  },
  methods: {
    handleSubmit() {
      this.onAdd(this.form);
      this.form = { name: "", email: "" };
    },
  },
};
</script>
