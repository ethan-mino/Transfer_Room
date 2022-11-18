<template>
  <div id="top">
    <form v-on:submit.prevent>
      <div class="input_board1">
        <span>제목</span>
        <div><input type="text" placeholder="제목" /></div>

        <span>층</span>
        <div><input type="text" placeholder="층" /></div>

        <span>방 종류</span>
        <div>
          <input type="text" placeholder="제목" />
        </div>
        <span>파일 업로드</span>
        <div>
          <input
            type="file"
            placeholder="파일 업로드"
            @change="previewImage($event)"
          />
          <img
            style="width: 400px; height: 400px"
            id="preview-image"
            :src="previewData"
          />
        </div>

        <span>내용 작성</span>
        <div>
          <textarea placeholder="내용작성" />
        </div>
      </div>
      <div class="finish__btn">
        <router-link :to="{ name: 'transferPage' }">
          <button type="button" class="btn me-2 save__btn">save</button>
        </router-link>
        <router-link :to="{ name: 'transferPage' }">
          <button type="button" class="btn me-2 cancel__btn">cancel</button>
        </router-link>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: "TransferAddVue",
  data() {
    return {
      previewData:
        "https://dummyimage.com/500x500/ffffff/000000.png&text=preview+image",
    };
  },
  methods: {
    //이미지 미리보기.
    previewImage: function (event) {
      var input = event.target;
      if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = (e) => {
          this.previewData = e.target.result;
        };

        reader.readAsDataURL(input.files[0]);
      }
    },
  },
};
</script>

<style>
#top {
  width: 100%;
  height: 100%;
  text-align: center;
}
.input_board1 {
  text-align: center;
}
.finish__btn {
  text-align: right;
}
.save__btn {
  background-color: #6c757d;
}
.cancel__btn {
  background-color: #c1beba;
}
</style>
