<template>
  <el-container style="height: 100%">
    <el-aside style="background-color: #e6eefb;" width="200px">
      <ui-header/>
    </el-aside>
    <el-main>
      <el-container>
        <transition name="fade">
          <div class="indexPageContainerArea">
            <router-view></router-view>
          </div>
        </transition>
      </el-container>
    </el-main>
  </el-container>
</template>

<script>
import uiHeader from "./UiHeader.vue";

export default {
  name: "index",
  components: {
    uiHeader
  },
}
</script>
<style>
body{
  font-family: sans-serif;
}
/*定义标题栏*/
.page-header {
  background-color: #FFFFFF;
  margin-bottom: 1rem;
  padding: 0.5rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.page-title {
  font-weight: bold;
  text-align: left;
}

.page-header-btn {
  text-align: right;
}
</style>
<style scoped>
.fade-enter {
  visibility: hidden;
  opacity: 0;
}

.fade-leave-to {
  display: none;
}

.fade-enter-active,
.fade-leave-active {
  transition: opacity .5s ease;
}

.fade-enter-to,
.fade-leave {
  visibility: visible;
  opacity: 1;
}

.indexPageContainerArea{
  padding: 20px;
  box-sizing: border-box;
  width: 100%;
}
</style>
