<template>
  <div id="app">
    
    <app-header />
    
    <router-view />

    <app-footer />
  </div>
</template>

<script>
import AppHeader from "./components/AppHeader.vue";
import AppFooter from "./components/AppFooter.vue";



export default {
  name: "app",
  components: { AppHeader, AppFooter},
};
</script>

<style>
 #app{
  background-image: url("../assets/new-notebook.png");
  background-repeat: no-repeat;
  background-size: cover;
  background-color: #000;
  font-weight: bold;
  }  
</style>


