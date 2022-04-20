<template>
  <transition name="modal-fade">
    <div class="modal-overlay" @click="$emit('close-modal')">
      <div class="modal" @click.stop>
        <div class="title">
          <h1> Reading details for: </h1>
        </div>
        <table class="parent">
            <label for="Children"></label>

              <tr>
                <th class='left-end-top'>Title</th>
                <th class='middle'>Author</th>
                <th class='middle'>Genre</th>
                <th class='right-end-top'>Minutes</th>
                <th class='right-end-top'>Times Read</th>
                <th class='right-end-top'>Date</th>
              </tr>

              <tr v-for="booklog in childData" :key="booklog.index">  
                <td class='left-end'>{{booklog.title}}</td> 
                <td class='middle'>{{booklog.author}}</td>
                <td class='middle'> {{booklog.genre}}</td>
                <td class='right-end'>{{booklog.minutes_per_book}}</td>
                <td class='right-end'>{{booklog.times_read_total}}</td>
                <td class='right-end'>{{booklog.last_read}}</td>

              </tr>
            </table> 
      </div>
      <div class="close" @click="$emit('close-modal')">
        <img class="close-img" src="src\assets\booklog.png" alt="" />
      </div>
      
    </div>
  </transition>
  
</template>

<script>
import BookService from "@/services/BookService";

  export default {
    name: 'child-modal-userID', 
    props: ['userDetail_id'],
  data() {
    return {

      childData: [] ,
      // showModal: false,

    }
  },
    computed: {
    currentUserId: function(){
      return this.$store.state.user.id
    }, 
  },
  created() {
    console.log('create idkwhatimdoinglol ', this.userDetail_id)
    BookService.getUserDetail(this.userDetail_id).then(response => {
      this.childData = response.data
    })
  }
  };
    

</script>

<style scoped>

.modal-overlay {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  display: flex;
  justify-content: center;
  background-color: #000000da;
}
.modal {
  text-align: center;
  background-color: #d9f5dd;
  height: 570px;
  width: 1200px;
  margin-top: 1%;
  padding: 0px 0;
  border-radius: 5px;
  overflow: scroll;
}
.close {
  margin: 10% 0 0 16px;
  cursor: pointer;
}
.close-img {
  width: 25px;
}
.modal-fade-enter,
.modal-fade-leave-to {
  opacity: 0;
}
.modal-fade-enter-active,
.modal-fade-leave-active {
  transition: opacity 0.5s ease;
}
</style>