<template>
 <div class="container">
    <div>
      <router-link v-bind:to="{ name: 'new-card' }"
        ><button class="header">About/Info</button></router-link>
  </div>
    <footer>&copy;Flashdex Tech Elevator 2022</footer>
  </div>
</template>

<script>
export default {
  name: "app-footer",
};
</script>

<style>
.container {
  display: flex;
  align-items: center;
  flex-wrap: nowrap;
  background: #cddee8;
  padding-left: 5px;
  padding-top: 5px;
  padding-bottom: 0;
}


.footer {
  flex-grow: 1;
  justify-content: space-evenly;
  flex-grow: 1;
  margin: 25px;
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  padding: 25px;
  background-color: #CDDEE8;
  border-radius: 10px;
  font-size: 20px;
  font-weight: bold;
  text-align: right;
}


.header:hover {
    text-decoration: underline;
}

</style>