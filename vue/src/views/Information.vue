<template>
  <div>
    <h1 class="aboutus">About Us</h1>
    <div class="about">
      <div class="name">
        <img src="../../assets/preston.png" alt="notebook" />
        <div class="nheader">
          <h3>Preston Masters</h3>
          <a href="https://www.linkedin.com/in/preston-masters" target="_blank"
            >Preston's Linkedin Page</a
          >
        </div>
        <div class="description">
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. A nisi
            laudantium aperiam unde recusandae vitae perferendis ad sed?
            Pariatur reiciendis consectetur veritatis culpa rerum nisi ipsa
            similique qui illum corporis.Lorem ipsum dolor sit amet consectetur
            adipisicing elit. A nisi laudantium aperiam unde recusandae vitae
            perferendis ad sed? Pariatur reiciendis consectetur veritatis culpa
            rerum nisi ipsa similique qui illum corporis.Lorem ipsum dolor sit
            amet consectetur adipisicing elit. A nisi laudantium aperiam unde
            recusandae vitae perferendis ad sed? Pariatur reiciendis consectetur
            veritatis culpa rerum nisi ipsa similique qui illum corporis.
          </p>
        </div>
      </div>
      <div class="name">
        <img src="../../assets/Asharpic.png" alt="notebook" />
        <div class="nheader">
          <h3>Ashar Bhatti</h3>
          <a href="https://www.linkedin.com/in/ashar-bhatti" target="_blank"
            >Ashar's Linkedin Page</a
          >
        </div>
        <div class="description">
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. A nisi
            laudantium aperiam unde recusandae vitae perferendis ad sed?
            Pariatur reiciendis consectetur veritatis culpa rerum nisi ipsa
            similique qui illum corporis.Lorem ipsum dolor sit amet consectetur
            adipisicing elit. A nisi laudantium aperiam unde recusandae vitae
            perferendis ad sed? Pariatur reiciendis consectetur veritatis culpa
            rerum nisi ipsa similique qui illum corporis.Lorem ipsum dolor sit
            amet consectetur adipisicing elit. A nisi laudantium aperiam unde
            recusandae vitae perferendis ad sed? Pariatur reiciendis consectetur
            veritatis culpa rerum nisi ipsa similique qui illum corporis.
          </p>
        </div>
      </div>
      <div class="name">
        <img src="../../assets/Kevin.png" alt="notebook" />
        <div class="nheader">
          <h3>Kevin Meindl</h3>
          <a href="https://www.linkedin.com/in/kevin-meindl" target="_blank"
            >Kevin's Linkedin Page</a
          >
        </div>
        <div class="description">
          <p>
            As a graduate of the Tech Elevator Java Bootcamp, I will be
            transitioning into an Associate Software Engineer role at KeyBank.
            In my time at Tech Elevator I learned Java, SQL, and JavaScript and
            how they all interact with each other to help build this program.
            The work/life balance that software development can offer was very
            appealing to me as a bonus feature to learning how to code. In my
            free time, I enjoy officiating all levels of hockey, exploring new
            restaurants around town with my wife and kids, and going on
            adventures with my family and our 2 dogs. Please, if you have any
            suggestions or recommendations, I would love to hear from you how to
            improve our site or hear any of your success stories.
          </p>
        </div>
      </div>
      <div class="name">
        <img src="../../assets/isabella.png" alt="notebook" />
        <div class="nheader">
          <h3>Isabella Tomasek</h3>
          <a
            href="https://www.linkedin.com/in/isabella-tomasek-dryer/"
            target="_blank"
            >Isabella's Linkedin Page</a
          >
        </div>
        <div class="description">
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. A nisi
            laudantium aperiam unde recusandae vitae perferendis ad sed?
            Pariatur reiciendis consectetur veritatis culpa rerum nisi ipsa
            similique qui illum corporis.Lorem ipsum dolor sit amet consectetur
            adipisicing elit. A nisi laudantium aperiam unde recusandae vitae
            perferendis ad sed? Pariatur reiciendis consectetur veritatis culpa
            rerum nisi ipsa similique qui illum corporis.Lorem ipsum dolor sit
            amet consectetur adipisicing elit. A nisi laudantium aperiam unde
            recusandae vitae perferendis ad sed? Pariatur reiciendis consectetur
            veritatis culpa rerum nisi ipsa similique qui illum corporis.
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "information",
};
</script>

<style>
.about {
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  text-align: center;
}
.name {
  margin-bottom: 20px;
  padding: 20px;
  border: solid 1px #555;
  background-color: #cddee8;
  border-radius: 15px;
}
.nheader {
  text-decoration: underline;
  display: flex;
  flex-direction: column;
  white-space: nowrap;
}
.aboutus {
  text-decoration: underline;
}
div.name:nth-child(1) {
  display: flex;
}
div.name:nth-child(2) {
  display: flex;
  flex-direction: row-reverse;
}
div.name:nth-child(3) {
  display: flex;
}
div.name:nth-child(4) {
  display: flex;
  flex-direction: row-reverse;
}
div.name:nth-child(1) > div.description {
  order: 2;
}
.about img {
  width: 125px;
  height: 125px;
  border-radius: 999px;
  margin: 0 10px;
}
.about:nth-child(1) > img {
  order: 1;
}
.description {
  padding: 20px;
}
.description > p {
  text-align: left;
}
</style>