from django.contrib.auth.models import AnonymousUser, User
from django.test import TestCase, Client, LiveServerTestCase
from selenium import webdriver
from selenium.webdriver.common.keys import Keys


# Create your tests here.

class SignUpTest(LiveServerTestCase):
    def setUp(self):
        self.driver = webdriver.Firefox()
        self.driver.maximize_window()

    def tearDown(self):
        self.driver.quit()

    def test_for_rendering(self):
        self.driver.get(
            '%s%s' % (self.live_server_url,  "/LoginApp/signup/")
        )

        username = self.driver.find_element_by_id('username')
        username.send_keys('abc')
        email = self.driver.find_element_by_id('email')
        email.send_keys('abc@gmail.com')
        password = self.driver.find_element_by_id('password')
        password.send_keys('abc')

        c = User.objects.count()

        # self.driver.find_element_by_xpath('//input[@value="Sign Up"]').click()
        self.driver.find_element_by_id("signupForm").submit()
        self.assertEqual(self.driver.current_url,'http://localhost:8081/LoginApp/signupSubmit/')

