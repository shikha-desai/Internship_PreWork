from django.contrib.auth.models import User, Group
from django.http import HttpResponse, HttpResponseRedirect
from django.core.urlresolvers import reverse
from django.shortcuts import get_object_or_404
from rest_framework import viewsets
from .serializers import UserSerializer, GroupSerializer
from rest_framework.renderers import TemplateHTMLRenderer
from rest_framework.views import APIView
import requests


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


class Signup(APIView):

    def post(self, request):
        requests.post("http://localhost:8000/users/", auth=('admin', 'password@admin'), data=request.data)
        return HttpResponseRedirect(reverse('LoginApp:signup'))
