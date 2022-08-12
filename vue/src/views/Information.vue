<template>
<div>
<h1 class="aboutus">About Us</h1>
  <div class="about">
      <div class="name">
        <img src="../../assets/preston.png" alt="notebook">
        <h3 class="nheader">Preston Masters</h3>
        <div class="description">
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. A nisi laudantium aperiam unde recusandae vitae
        perferendis ad sed? Pariatur reiciendis consectetur veritatis culpa rerum nisi ipsa similique qui illum
        corporis.Lorem ipsum dolor sit amet consectetur adipisicing elit. A nisi laudantium aperiam unde recusandae vitae
        perferendis ad sed? Pariatur reiciendis consectetur veritatis culpa rerum nisi ipsa similique qui illum
        corporis.Lorem ipsum dolor sit amet consectetur adipisicing elit. A nisi laudantium aperiam unde recusandae vitae
        perferendis ad sed? Pariatur reiciendis consectetur veritatis culpa rerum nisi ipsa similique qui illum
        corporis.</p>
        </div>
      </div>
      <div class="name">
        <img src="../../assets/notebook.png" alt="notebook">
        <h3 class="nheader">Ashar Bhatti</h3>
        <div class="description">
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. A nisi laudantium aperiam unde recusandae vitae
        perferendis ad sed? Pariatur reiciendis consectetur veritatis culpa rerum nisi ipsa similique qui illum
        corporis.Lorem ipsum dolor sit amet consectetur adipisicing elit. A nisi laudantium aperiam unde recusandae vitae
        perferendis ad sed? Pariatur reiciendis consectetur veritatis culpa rerum nisi ipsa similique qui illum
        corporis.Lorem ipsum dolor sit amet consectetur adipisicing elit. A nisi laudantium aperiam unde recusandae vitae
        perferendis ad sed? Pariatur reiciendis consectetur veritatis culpa rerum nisi ipsa similique qui illum
        corporis.</p>
        </div>
      </div>
      <div class="name">
        <img src="../../assets/Kevin.png" alt="notebook">
        <h3 class="nheader">Kevin Meindl</h3>
        <div class="description">
        <p>I have many years of experience training numerous team members. As </p>
        </div>
      </div>
      <div class="name">
        <img src="../../assets/isabella.png" alt="notebook">
        <h3 class="nheader">Isabella Tomasek</h3>
        <div class="description">
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. A nisi laudantium aperiam unde recusandae vitae
        perferendis ad sed? Pariatur reiciendis consectetur veritatis culpa rerum nisi ipsa similique qui illum
        corporis.Lorem ipsum dolor sit amet consectetur adipisicing elit. A nisi laudantium aperiam unde recusandae vitae
        perferendis ad sed? Pariatur reiciendis consectetur veritatis culpa rerum nisi ipsa similique qui illum
        corporis.Lorem ipsum dolor sit amet consectetur adipisicing elit. A nisi laudantium aperiam unde recusandae vitae
        perferendis ad sed? Pariatur reiciendis consectetur veritatis culpa rerum nisi ipsa similique qui illum
        corporis.</p>
        </div>
      </div>
  </div>
  </div>
</template>

<script>
export default {
    name: "information"
}
</script>

<style>
.about{
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  text-align: center;
  
}
.name{
  margin-bottom: 20px;
  padding: 20px;
  border: solid 1px #555;
  /* background-color: #c9e3da ; */
}
.nheader{
  text-decoration: underline;
  display: flex;
  white-space:nowrap;
}
.aboutus{
  text-decoration: underline;
}
div.name:nth-child(1){
  display: flex;
}
div.name:nth-child(2){
  display: flex;
  flex-direction: row-reverse;
}
div.name:nth-child(3){
  display: flex;
}
div.name:nth-child(4){
  display: flex;
  flex-direction: row-reverse;
}
div.name:nth-child(1)>div.description{
  order: 2;
}
.about img{
  width: 125px;
  height: 125px;
  border-radius: 999px;
  margin: 0 10px;
}
.about:nth-child(1)>img{
  order: 1;
}
.description{
  padding:20px;
    
}
.description>p{
  text-align:left;
}




</style>