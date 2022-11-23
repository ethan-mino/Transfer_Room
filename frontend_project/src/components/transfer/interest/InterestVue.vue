<template>
  <div>
    <div
      class="interesting-area"
      v-for="item in interestingInfos"
      :key="item.dongCode"
    >
      <div class="interesting-content" @click="interesting(item.dongCode)">
        <!-- <input class="dongCode" type="hidden" value="${data.dongCode}"/>
          <input class="id" type="hidden" value="${data.id}"/> -->

        <span class="region"
          >관심지역 : {{ item.sidoName }} {{ item.gugunName }}
          {{ item.dongName }}</span
        ><br />
        <span class="interesting-create-date"
          >생성일 : {{ item.interestingAreaCreateTime }}</span
        >
      </div>
      <div class="close" @click="deleteValue(item.interestingAreaId)"></div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
const interestingStore = "interestingStore";
export default {
  name: "InterestVue",
  computed: {
    ...mapState(interestingStore, ["interestingInfos"]),
  },
  methods: {
    ...mapActions(interestingStore, ["deleteInteresting"]),
    //해당 관심지역을 삭제하는 코드
    deleteValue: async function (id) {
      console.log("check111");
      await this.deleteInteresting(id);
    },
    //관심지역으로 지도 이동.
    interesting: function (dongcode) {
      this.$emit("dongCode", dongcode);
    },
  },
};
</script>

<style></style>
