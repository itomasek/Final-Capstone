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
            I am beyond excited to have recently taken a new position as an
            Associate Software Engineer with KeyBank after graduating from the
            Tech Elevator Java Bootcamp in August 2022. My educational
            background is in music (BM Voice Performance from Florida State
            University, MM Music Composition from Cleveland State University),
            and I am continually fascinated by the creative connection between
            reading and writing code and reading and writing music. In my spare
            time I enjoy playing the piano, sampling local nightlife and
            restaurants, and keeping up on the latest opera gossip. As a
            Cleveland, Ohio native I also enjoy pretending to be devoted to the
            Browns, which is a wonderful exercise in humility. Thank you for
            checking out <em>FLASHDEX</em>!
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
            Diehard Yankees fan, married and have a four years old son. After
            working 20 years in few different Operations roles with KeyBank
            within various departments and my most recent role as ACH Lead
            Specialist. Got accepted in a new role as Software Engineering.
            After graduating from Tech Elevator Bootcamp will be joining new
            position with KeyBank. In my spare time, love to spend time with my
            family, specially with my son. Taking him out to parks, bouncing
            bounce, fairs and kids rides. I enjoy watching football and baseball
            games just to have father and son time together. Hoping that he will
            become a "Yankees fan".
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
            After 14 weeks of an intense, complicated, but lifechanging boot
            camp with Tech Elevator, I'm happy to announce that I have taken a
            position as an Associate Software Engineer for KeyBank! The time
            spent learning and working with code from Tech Elevator has taught
            me to be more patient and kind to myself because a lot of it has to
            do with trial and error, especially when starting out so fresh. My
            educational background is in Criminal Justice - I know, a far jump
            from software development. It's definitely still my passion, but I
            love the challenge of software development! When I'm not working,
            I'm relaxing with my dogs, working on my side business, or baking
            some cookies.
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

div.description > p {
   text-indent: 35px;
}
</style>