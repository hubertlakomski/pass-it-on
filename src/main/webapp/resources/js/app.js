document.addEventListener("DOMContentLoaded", function() {

  /**
   * Form Select
   */
  class FormSelect {
    constructor($el) {
      this.$el = $el;
      this.options = [...$el.children];
      this.init();
    }

    init() {
      this.createElements();
      this.addEvents();
      this.$el.parentElement.removeChild(this.$el);
    }

    createElements() {
      // Input for value
      this.valueInput = document.createElement("input");
      this.valueInput.type = "text";
      this.valueInput.name = this.$el.name;

      // Dropdown container
      this.dropdown = document.createElement("div");
      this.dropdown.classList.add("dropdown");

      // List container
      this.ul = document.createElement("ul");

      // All list options
      this.options.forEach((el, i) => {
        const li = document.createElement("li");
        li.dataset.value = el.value;
        li.innerText = el.innerText;

        if (i === 0) {
          // First clickable option
          this.current = document.createElement("div");
          this.current.innerText = el.innerText;
          this.dropdown.appendChild(this.current);
          this.valueInput.value = el.value;
          li.classList.add("selected");
        }

        this.ul.appendChild(li);
      });

      this.dropdown.appendChild(this.ul);
      this.dropdown.appendChild(this.valueInput);
      this.$el.parentElement.appendChild(this.dropdown);
    }

    addEvents() {
      this.dropdown.addEventListener("click", e => {
        const target = e.target;
        this.dropdown.classList.toggle("selecting");

        // Save new value only when clicked on li
        if (target.tagName === "LI") {
          this.valueInput.value = target.dataset.value;
          this.current.innerText = target.innerText;
        }
      });
    }
  }
  document.querySelectorAll(".form-group--dropdown select").forEach(el => {
    new FormSelect(el);
  });

  /**
   * Hide elements when clicked on document
   */
  document.addEventListener("click", function(e) {
    const target = e.target;
    const tagName = target.tagName;

    if (target.classList.contains("dropdown")) return false;

    if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
      return false;
    }

    if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
      return false;
    }

    document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
      el.classList.remove("selecting");
    });
  });

  /**
   * Switching between form steps
   */
  class FormSteps {
    constructor(form) {
      this.$form = form;
      this.$next = form.querySelectorAll(".next-step");
      this.$prev = form.querySelectorAll(".prev-step");
      this.$step = form.querySelector(".form--steps-counter span");
      this.currentStep = 1;

      this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
      const $stepForms = form.querySelectorAll("form > div");
      this.slides = [...this.$stepInstructions, ...$stepForms];

      this.init();
    }

    /**
     * Init all methods
     */
    init() {
      this.events();
      this.updateForm();
    }

    /**
     * All events that are happening in form
     */
    events() {
      // Next step
      this.$next.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep++;
          this.updateForm();
        });
      });

      // Previous step
      this.$prev.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep--;
          this.updateForm();
        });
      });

      // Form submit
      this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
    }

    /**
     * Update form front-end
     * Show next or previous section etc.
     */

    bagsInfo(){

      const categories = this.$form.getElementsByClassName("category");
      let bagsCategories = "";

      if(categories.length>0){
        for(var i = 0; i < categories.length; i++) {

          if (categories[i].querySelector("input").checked == true) {

            console.log(i);
            if(i==0){
              bagsCategories = categories[i].querySelector(".description").innerHTML;
            }
            else{
              bagsCategories = bagsCategories + ", " + categories[i].querySelector(".description").innerHTML;
            }

          }

        }
      }

      const bagsInfo = this.$form.querySelector("#bagsInfo");
      const bagsNumber = this.$form.querySelector("#bagsNumber").value;

      //tak wiem, że te końcówki ek, ki, ów nie są do końca poprawne :)

      if(bagsNumber>0){
        if(bagsNumber==1){
          bagsInfo.innerText = bagsNumber + " worek z kategorii: "+bagsCategories;
        }
        else if(bagsNumber<5){
          bagsInfo.innerText = bagsNumber + " worki z kategorii: "+bagsCategories;
        }
        else{
          bagsInfo.innerText = bagsNumber + " worków z kategorii: "+bagsCategories;
        }
      }

    }

    institutionInfo(){
      const institutionInfo = this.$form.querySelector("#institutionInfo");
      const institution = this.$form.getElementsByClassName("institution");

      if(institution.length>0){
        for(var i = 0; i < institution.length; i++) {

          if (institution[i].querySelector("input").checked == true) {

            institutionInfo.innerText =
                'Dla fundacji: "'+ institution[i].querySelector(".description > .title").innerText+'"';

          }

        }
      }
    }

    addressInfo(){
      this.$form.querySelector("#streetInfo").innerText = this.$form.querySelector("#street").value;
      this.$form.querySelector("#cityInfo").innerText = this.$form.querySelector("#city").value;
      this.$form.querySelector("#zipCodeInfo").innerText = this.$form.querySelector("#zipCode").value;
    }

    pickUpInfo(){
      this.$form.querySelector("#pickUpDateInfo").innerText = this.$form.querySelector("#pickUpDate").value;
      this.$form.querySelector("#pickUpTimeInfo").innerText = this.$form.querySelector("#pickUpTime").value;

      if(this.$form.querySelector("#pickUpComment").value === ""){
        this.$form.querySelector("#pickUpCommentInfo").innerText = "Brak uwag";
      }
      else{
        this.$form.querySelector("#pickUpCommentInfo").innerText = this.$form.querySelector("#pickUpComment").value;
      }
    }

    updateForm() {
      this.$step.innerText = this.currentStep;

      // TODO: Validation

      this.slides.forEach(slide => {
        slide.classList.remove("active");

        if (slide.dataset.step == this.currentStep) {
          slide.classList.add("active");
        }
      });

      this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
      this.$step.parentElement.hidden = this.currentStep >= 5;

      if(this.currentStep==5){

        this.bagsInfo();
        this.institutionInfo();
        this.addressInfo();
        this.pickUpInfo();
      }

      // TODO: get data from inputs and show them in summary
    }

  }
  const form = document.querySelector(".form--steps");
  if (form !== null) {
    new FormSteps(form);
  }
});
