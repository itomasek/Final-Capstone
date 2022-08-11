<template>
  <div id="app">
    
    <app-header />
    
    <router-view />

    <app-footer></app-footer>
  </div>
</template>

<script>
import AppHeader from "./components/AppHeader.vue";
import AppFooter from "./components/AppFooter.vue";


export default {
  name: "app",
  components: { AppHeader,AppFooter},
};
</script>

<style>


</style>

