from django.contrib.auth.models import User, Group
from django.http import HttpResponse, HttpResponseRedirect
from django.core.urlresolvers import reverse
from django.shortcuts import get_object_or_404
from rest_framework import viewsets
from .serializers import UserSerializer, GroupSerializer
from rest_framework.renderers import TemplateHTMLRenderer
from rest_framework.views import APIView
import requests
import logging
from django.views.generic import View
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.hashers import make_password
from django.core.urlresolvers import resolve


class UserViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows users to be viewed or edited.
    """
    queryset = User.objects.all().order_by('-date_joined')
    serializer_class = UserSerializer


class GroupViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows groups to be viewed or edited.
    """
    queryset = Group.objects.all()
    serializer_class = GroupSerializer


class Signup(View):
    def post(self, request):
        logger = logging.getLogger(__name__)
        # print("Logger name :" + __name__)
        logger.info("entered post view")
        passwd = request.POST['password']
        passwd = make_password(passwd)
        data = {'username': request.POST['username'], 'email': request.POST['email'], 'password': passwd}
        logger.info(request.get_host())
        logger.info(resolve(request.path).app_name)
        # url = 'http://' + request.get_host() + '/' + resolve(request.path).app_name + '/users/'
        url = 'http://localhost:8000/LoginApp/users/'
        response = requests.post(url, auth=('admin', 'password@admin'), data=data)
        if response.status_code == 201:
            logger.info(response.status_code)
            logger.info("post request done")
            return HttpResponseRedirect(reverse('LoginApp:index'))
        else:
            logger.info(response.status_code)
            logger.info("post request not successful")
            return HttpResponseRedirect(reverse('LoginApp:signup'))


class Login(View):
    def post(self, request):
        logger = logging.getLogger(__name__)
        username = request.POST['username']
        password = request.POST['password']
        user = authenticate(username=username, password=password)
        if user is not None:
            logger.info("Login successful")
            logger.info(user.id)
            login(request, user)
            return HttpResponseRedirect(reverse('LoginApp:home', args=(user.id,)))
        logger.info("Login failed")
        return HttpResponseRedirect(reverse('LoginApp:login'))


def logout_view(request):
    logout(request)
    return HttpResponseRedirect(reverse('LoginApp:index'))