<template>
 <div class="container">
    <div>
      <router-link v-bind:to="{ name: 'info' }"
        ><button class="footer-button">About/Info</button></router-link>
  </div>
    <div class="footer-copyright">&copy;Flashdex Tech Elevator 2022</div>
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
  flex-wrap: nowrap;
  background: #cddee8;
  padding:10px;
  margin-top:10px;
  
}


.footer-button {
  
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  padding: 10px;
  background-color: #CDDEE8;
  border-radius: 5px;
  margin: auto;
}

#footer-copyright{
    font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
    
    text-justify: right;
}
div.footer-copyright:nth-child(1) > div.button.class{
  order: 2;
}


.footer-button:hover {
    text-decoration: underline;
}


</style>